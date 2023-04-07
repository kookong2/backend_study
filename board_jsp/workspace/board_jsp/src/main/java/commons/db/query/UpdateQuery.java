package commons.db.query;

public interface UpdateQuery {
	// 회원 정보 수정(update) query
	<T> int update(T t, String mapper);

}
