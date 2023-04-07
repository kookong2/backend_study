package org.koreait.config;

import org.koreait.interceptors.MemberOnlyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
@EnableWebMvc
@Import({ DbConfig.class, ServiceConfig.class })
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;

	@Value("${environment}")
	private String environment;

	// @EnableWebMvc 어노테이션은 스프링 MVC를 사용하는데 필요한 기본적인 구성을 설정한다면,
	// WebMvcConfiurer 인터페이스는 스프링 MVC의 개별 설정을 조정할 때 사용

	// configureDefaultServletHandling() 메서드와 configureViewResolvers() 메서드는
	// WebMvcConfigurer 인터페이스에
	// 정의된 메서드로 각각 디폴트 서블릿과 ViewResolver와 관련된 설정을 조정
	// 이 두 메서드가 내부적으로 생성한 설정의 경우에도 관련 빈을 직접 설정하면 20~30여 줄의 코드를 작성해야한다.

	@Value("${file.uploadPath}")
	private String fileUploadPath;

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// DispatcherServlet의 매핑 경로를 '/'로 주었을 때, JSP/HTML/CSS등을 올바르게 처리하기 위한 설정을 추가

		configurer.enable();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("main/index");

		registry.addViewController("/mypage").setViewName("user/mypage");

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// CSS, JS, 이미지 등 정적인 지원들을 저장할 경로를 지정한다 (src/main/resources/static 경로 생성)
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

		registry.addResourceHandler("/uploads/**").addResourceLocations("file:///" + fileUploadPath);
	}

	/**
	 * @Override public void configureViewResolvers(ViewResolverRegistry registry) {
	 *           // JSP를 이용해서 컨트롤러 실행 결과를 보여주기 위한 설정을 추가 // WebMvcConfigurer 인터페이스에
	 *           정의된 configureViewResolvers() 메서드는 // ViewReolverRegistry 타입의
	 *           registry 파라미터를 갖는다.
	 * 
	 *           // 이 코드는 JSP를 뷰 구현으로 사용할 수 있도록 해주는 설정 // jsp()메서드의 첫 번째 인자는 JSP 경로를
	 *           찾을 때 사용하는 접두어, 두 번째는 접미사 // 뷰 이름의 앞과 뒤에 각각 접두어와 접미사를 붙여서 최종적으로 사용 할
	 *           JSP 파일의 경로를 결정 registry.jsp("/WEB-INF/view/", ".jsp"); }
	 */

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setDefaultEncoding("UTF-8");
		ms.addBasenames("messages.commons");

		return ms;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(memberOnlyInterceptor()).addPathPatterns("/mypage/**");
	}

	@Bean
	public MemberOnlyInterceptor memberOnlyInterceptor() {
		return new MemberOnlyInterceptor();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		
		// 설정파일 불러올 수 있게 하는 클래스 
		
		PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();

		conf.setLocations(new ClassPathResource("application.properties"));
		return conf;
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		boolean cacheable = environment.equals("real") ? true : false;

		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		// 경로 설정해주는 것
		templateResolver.setPrefix("/WEB-INF/view/");
		// 파일 타입 설정하는 것
		templateResolver.setSuffix(".html");
		// 웹이 캐쉬됨을 켜고 끄게 할 수 있는 기능 (개발할 때는 false로, 베포할 때는 true)
		templateResolver.setCacheable(cacheable);
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		// 이거 알아보기
		
		
		
		
		
		
		templateEngine.setEnableSpringELCompiler(true);
		// 확장 모듈 넣는 것 (thymeleaf - Java8Time, Layout)
		templateEngine.addDialect(new Java8TimeDialect());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setContentType("text/html");
		// 인코딩 관련
		resolver.setCharacterEncoding("utf-8");
		resolver.setTemplateEngine(templateEngine());
		return resolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(thymeleafViewResolver());
	}

}
