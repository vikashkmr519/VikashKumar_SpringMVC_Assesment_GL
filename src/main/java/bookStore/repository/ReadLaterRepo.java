package bookStore.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookStore.entity.ReadLater;

@Repository
public class ReadLaterRepo {

	@Autowired
	private SessionFactory factory;
	
	public void insert(ReadLater readLater) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		session.persist(readLater);
		trx.commit();
		session.close();
	}
	
	public List<Integer> fetchAllListForUser(String email){
		Session session = factory.openSession();
		List<Integer> list = session.createQuery("select bookid from ReadLater where useremail=:email").setParameter("email", email).getResultList();
		
		session.close();
		return list;
	}
	
	public void deleteLb(String email, int bookid) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		session.createQuery("delete from ReadLater where useremail=:email and bookid=:bookid")
		.setParameter("email", email)
		.setParameter("bookid", bookid)
		.executeUpdate();
		
		trx.commit();
		session.close();
	}
	
	public boolean readLaterExists(ReadLater readLater) {
		Session session = factory.openSession();
		List<ReadLater> rl = session.createQuery("from ReadLater where useremail=:email and bookid=:bookid ")
				.setParameter("email", readLater.getUseremail())
				.setParameter("bookid", readLater.getBookid())
				.getResultList();
		session.close();
		if(rl.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
