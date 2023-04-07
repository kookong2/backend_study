package config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//sql을 가져오는 객체 생성 후 db연결
public class MyConnection {

	private static SqlSessionFactory sqlSessionFactory;
	
	static { 
		try {
			// db정보와 sql 실행을 위한 mapping 설정은 mybatis-config에서 작성
			//이 클래스는 mybatis에 있는 것을 가져와 db에 접속할 수 있는 객체 생성
			Reader reader = Resources.getResourceAsReader("config/mybatisconfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"dev");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}
