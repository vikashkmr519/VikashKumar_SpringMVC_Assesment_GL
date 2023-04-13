package bookStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStore.entity.Book;
import bookStore.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;
	
	public List<Book> getAllBooks(){
		System.out.println("BookServcie method called");
		return this.repo.getAllBooks();
	}
	
	public List<Book> booksForBookIdsAndEmail(List<Integer> bookIds){
		List<Book> books = new ArrayList<Book>();
		for(int id : bookIds) {
			Book book  = this.repo.getById(id);
			if(book!=null) {
				books.add(book);
			}
		}
		
		return books;
		
	}
}
