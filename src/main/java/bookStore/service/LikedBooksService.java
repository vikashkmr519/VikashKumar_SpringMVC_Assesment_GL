package bookStore.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStore.entity.LikedBooks;
import bookStore.entity.ReadLater;
import bookStore.repository.LikedBookRepo;

@Service
public class LikedBooksService {

	
	@Autowired
	private LikedBookRepo repo;
	
	public void insert(LikedBooks books) {
		
			if(!repo.likedBookExists(books)) {
				this.repo.insert(books);
			}
		}
	

	
	public List<Integer> fetchBookIdForUser(String email) {
		return this.repo.fetchBookIdForUser(email);
	}
	
	public void deleteLb(String email, int bookid) {
		this.repo.deleteLb(email, bookid);
	}
}
