package commons.db.query;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyConnection;

public class QueryExecutor implements InsertQuery,UpdateQuery,SelectQuery,DeleteQuery {

	private SqlSession session = null;
	// 세션은 웹서버에 존재하는 객체
	//  이 객체를 쿼리(mapper)를 통해서 가져와 memberdao에서 직접 접근할 수 있다. 
	
	//세션 가져오기 공통 method
	public SqlSession getSession() {
		if(session==null) {
			session=MyConnection.getSession();
		}
		return session;
	}
	
	@Override
	public <T> int delete(T t, String mapper) {
		session=getSession();
		int cnt = t ==null? session.delete(mapper):session.delete(mapper,t);
		return 0;
	}

	@Override
	public <T, R> List<R> query(T t, String mapper) {
		session=getSession();
		List<R> list=session.selectList(mapper, t);
		session.commit();
		return null;
	}

	@Override
	public <R> List<R> query(String mapper) {
		session=getSession();
		List<R>	list= session.selectList(mapper);
		return null;
	}

	@Override
	public <T, R> R queryOne(T t, String mapper) {
		session = getSession();
		R data=session.selectOne(mapper,t);
		return data;
	}

	@Override
	public <R> R queryOne(String mapper) {
		session = getSession();
		R data=session.selectOne(mapper);
		return data;
	}

	@Override
	public <T> int count(T t, String mapper) {
		session=getSession();
		int cnt=session.selectOne(mapper,t);
		return cnt;
	}

	@Override
	public <T> int update(T t, String mapper) {
		session=getSession();
		int cnt= t==null?session.update(mapper):session.update(mapper,t);
		session.commit();
		return cnt;
		
	}

	@Override
	public <T> int insert(T t, String mapper) {
		session=getSession();
		int cnt=t==null?session.insert(mapper):session.insert(mapper,t);
		session.commit();
		return cnt;
	}


}
