package day17.sub1;

import java.util.Objects;

public class Book {
	private String title; // 책 제목
	private String author; // 저자
	private String publisher; // 출판사
	
	
	public Book(String title, String author, String publisher) {
		
		this.title = title;
		this.author = author;
		this.publisher = publisher;
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
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + "]" + hashCode();
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
			if(toString().equals(book.toString())) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
}
