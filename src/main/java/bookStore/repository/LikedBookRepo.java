package bookStore.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookStore.entity.LikedBooks;
import bookStore.entity.ReadLater;

@Repository
public class LikedBookRepo {

	
	@Autowired
	private SessionFactory factory;
	
	public void insert(LikedBooks books) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		session.persist(books);
		trx.commit();
		session.close();
		
	}
	
	public List<Integer> fetchBookIdForUser(String email) {
		Session session = factory.openSession();
		List<Integer> list = session.createQuery("select bookid from LikedBooks where useremail=:email").setParameter("email", email).getResultList();
		
		session.close();
		return list;
	}
	
	public void deleteLb(String email, int bookid) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		session.createQuery("delete from LikedBooks where useremail=:email and bookid=:bookid")
		.setParameter("email", email)
		.setParameter("bookid", bookid)
		.executeUpdate();
		
		trx.commit();
		session.close();
	}
	
	public boolean likedBookExists(LikedBooks likedBooks) {
		Session session = factory.openSession();
		List<LikedBooks> lb = session.createQuery("from LikedBooks where useremail=:email and bookid=:bookid ")
				.setParameter("email", likedBooks.getUseremail())
				.setParameter("bookid", likedBooks.getBookid())
				.getResultList();
		session.close();
		if(lb.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
