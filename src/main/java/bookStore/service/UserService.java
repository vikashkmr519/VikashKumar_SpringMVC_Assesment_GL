package bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStore.dto.LoginDto;
import bookStore.entity.User;
import bookStore.repository.UserRepo;

@Service
public class UserService {

	
	@Autowired
	private UserRepo repo;
	
	
	public boolean login(LoginDto dto) {
		return this.repo.loginUser(dto);
	}
	
	public boolean register(User user) {
		return this.repo.registerUser(user);
	}
	
	public User getUser(String email) {
		return this.repo.getUser(email);
	}
}
