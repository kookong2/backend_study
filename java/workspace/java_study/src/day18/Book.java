package day18;

import java.util.Objects;

public class Book implements Comparable<Book>{
	private String title;		//책 제목
	private String author;		//책 저자
	private String publisher;	//출판사
	private int price;			//책 가격
	
	public Book(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher +", price=" + price + "]";
	}
	
	@Override
	public int hashCode() {

		int hashcode = Objects.hash(title, author, publisher);
		
		return hashcode;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Book) {
			Book book = (Book)obj;
			
			if(title.equals(book.title)&&author.equals(book.author)&&publisher.equals(book.publisher)) {
				return true;
			}
		}
				
		return false;
	}

	@Override
	public int compareTo(Book o) {
		// *-1 을 해주면 내림차순으로 바꿈
		/*
		String bookTitle = o.getTitle();
		
		return title.compareTo(bookTitle);
		*/
		
		Integer _price = price;
		
		return _price.compareTo(o.price);
	} 
	
}
