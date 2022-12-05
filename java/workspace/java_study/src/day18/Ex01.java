package day18;

import java.util.HashSet;

public class Ex01 {
	public static void main(String[] args) {
		
		HashSet<Book> books = new HashSet<>();
		books.add(new Book("책2", "저자2", "출판사2",9000));
		books.add(new Book("책3", "저자3", "출판사3",8000));
		books.add(new Book("책4", "저자4", "출판사4",11000));
		books.add(new Book("책1", "저자1", "출판사1",12000));
		books.add(new Book("책3", "저자3", "출판사3",5000));
		
		for(Book book : books) {
			System.out.println(book);
		}
		
		
	}
}
