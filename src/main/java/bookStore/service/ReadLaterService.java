package bookStore.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStore.entity.ReadLater;
import bookStore.repository.ReadLaterRepo;

@Service
public class ReadLaterService {

	
	@Autowired
	private ReadLaterRepo repo;
	
	
	public void insert(ReadLater readLater) {
		if(!repo.readLaterExists(readLater)) {
			this.repo.insert(readLater);
		}
	}
	
	public List<Integer> fetchAllListForUser(String email){
		return this.repo.fetchAllListForUser(email);
	}
	
	public void deleteLb(String email, int bookid) {
		this.repo.deleteLb(email, bookid);
	}
}

