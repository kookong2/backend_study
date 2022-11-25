package day12.sub3;

public class DBConnection implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("자원 해제!");
		
	}
	
}
