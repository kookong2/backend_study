package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {
	
	@Value("${environment}")
	private String environment;
	
	@Value("${db.dev.username}")
	private String username_dev;
	
	@Value("${db.dev.password}")
	private String password_dev;
	
	@Value("${db.dev.initialSize}")
	private String initialSize_dev;
	
	@Value("${db.dev.maxActive}")
	private String maxActive_dev;
	
	@Value("${db.real.username}")
	private String username_real;
	
	@Value("${db.real.password}")
	private String password_real;
	
	@Value("${db.real.initialSize}")
	private String initialSize_real;
	
	@Value("${db.real.maxActive}")
	private String maxActive_real;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		
		String username = username_dev;
		String password = password_dev;
		String initialSize = initialSize_dev;
		String maxActive = maxActive_dev;
		
		if (environment.equals("real")) {
			username = username_real;
			password = password_real;
			initialSize = initialSize_real;
			maxActive = maxActive_real;
		}
		
		String url = "jdbc:mysql://localhost:3306/board";
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(Integer.parseInt(initialSize));
		ds.setMaxActive(Integer.parseInt(maxActive));
		ds.setTestWhileIdle(true);
		ds.setTimeBetweenEvictionRunsMillis(10000); // 커넥션 풀 연결 객체 DB 연결 상태 체크 10초 주기 
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
