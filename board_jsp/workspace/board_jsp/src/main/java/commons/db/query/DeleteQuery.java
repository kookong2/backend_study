package commons.db.query;

public interface DeleteQuery {
	// 회원정보 삭제(delete) query
	<T> int delete(T t, String mapper);

}
