package bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bookStore.entity.User;
import bookStore.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(User user) {
		if(this.userService.register(user)) {
			return "redirect:/login";
		}
		
		return "redirect:/login?error=invalid";
	}

}
