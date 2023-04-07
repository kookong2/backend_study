package org.koreait.exam;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Greet implements InitializingBean, DisposableBean{
	
	
	public void hello(String name) {
		System.out.printf("%s씨, 이해 되셨나요?.%n", name);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertySet!");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("아뇨 ㅎ");
		
	}
}
