package bookStore.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookStore.dto.LoginDto;
import bookStore.entity.User;

@Repository
public class UserRepo {

	@Autowired
	private SessionFactory factory;
	
	public List<User> getUsers() {
		Session session = factory.openSession();
		System.out.println("User repo entered");
		List<User> users =  session.createQuery("from User", User.class).getResultList();
		session.close();
		return users;
	}
	
	public boolean registerUser(User user) {
		Session session = factory.openSession();
		try {
		Transaction trx = session.beginTransaction();
		session.persist(user);
		trx.commit();
		session.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean loginUser(LoginDto dto) {
		Session session = factory.openSession();
		User user = session.get(User.class, dto.getEmail());
		
		if(user.getPassword().equals(dto.getPassword())) {
			return true;
		}
		session.close();
		return false;
	}
	
	public User getUser(String email) {
		Session session = factory.openSession();
		User user = session.get(User.class, email);
		session.close();
		return user;
	}
}
