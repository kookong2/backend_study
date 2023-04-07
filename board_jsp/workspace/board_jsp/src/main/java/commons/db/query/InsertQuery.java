package commons.db.query;

public interface InsertQuery {
	// 회원 등록(insert) 쿼리
	<T> int insert(T t, String mapper);

}
