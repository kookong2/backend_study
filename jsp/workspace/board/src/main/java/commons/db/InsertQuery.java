package commons.db;

public interface InsertQuery{
	<T > int insert(T t, String mapper); //추가 INSERT쿼리
		
}
