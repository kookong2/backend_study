package commons.db.query;

import java.util.List;

public interface SelectQuery {
	// T: 아이디,이름 등 변수
	// R: T 의 값
	// 목록조회
	<T,R> List<R> query(T t, String mapper);
	<R> List<R> query(String mapper);
	
	// 단일 조회 
	<T,R> R queryOne(T t, String mapper); // 값이 있어야한 하는거 고를 때 
	<R> R queryOne(String mapper); // default값 있는것들 .. 아마도..?
	
	// 갯수 체크 userId로 검색하는 거니까 T만 있으면 가능 
	<T> int count(T t, String mapper); // 회원 수 체크
	

}
