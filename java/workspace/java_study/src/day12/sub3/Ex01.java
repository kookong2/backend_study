package day12.sub3;

public class Ex01 {
	public static void main(String[] args) {
		
		try(DBConnection conn = new DBConnection()) {
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
