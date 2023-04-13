package bookStore.repository;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookStore.entity.Book;

@Repository
public class BookRepo {

	@Autowired
	private SessionFactory factory;
	
	public List<Book> getAllBooks(){
		System.out.println("Book Repo entered");
		Session session = factory.openSession();
		List<Book> books = session.createQuery("from Book", Book.class).getResultList();
		return books;
	}
	
	public Book getById(int id) {
		Session session = factory.openSession();
		Book book = session.get(Book.class,id);
		session.close();
		return book;
	}
}
