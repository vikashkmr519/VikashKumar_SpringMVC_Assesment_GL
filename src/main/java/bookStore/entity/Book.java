package bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookid;
	
	private String bookname;
	
	private String publication;
	
	private String price;
	
	private String authorname;
	
	public Book() {
		
	}

	public Book(int bookid, String bookname, String publication, String price, String authorname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.publication = publication;
		this.price = price;
		this.authorname = authorname;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", publication=" + publication + ", price=" + price
				+ ", authorname=" + authorname + "]";
	}
	
	
	

}

