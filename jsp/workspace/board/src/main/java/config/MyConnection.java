package config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//sql을 읽어서 가져오는 것 
public class MyConnection {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
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
