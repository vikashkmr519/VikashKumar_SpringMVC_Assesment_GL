package bookStore.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookStore.dto.LoginDto;
import bookStore.service.UserService;


@Controller
public class LoginCOntroller {

	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/login")
	public String login( Map<String, String> errorMap, @RequestParam(required = false) String error) {
		
		if(error!=null) {
			errorMap.put("error", error);
		}
		
		return "login";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,
			HttpServletResponse resp,
			HttpServletRequest request)
	{
		Cookie cookies[] = request.getCookies();
		System.out.println(cookies.length);
		for(Cookie cookie : cookies)
		{
			System.out.println(cookie.getName());
			if(cookie.getName().equals("email"))
				cookie.setMaxAge(0);
			else if(cookie.getName().equals("JSESSIONID"))
				cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String loginPOstPage(LoginDto dto, HttpServletRequest request,
			HttpSession session, HttpServletResponse resp, Map<String, String> map)
	{
		// POST
		System.out.println("login request "+request.getMethod());
		System.out.println("email "+dto.getEmail());
		System.out.println("pwd "+dto.getPassword());
		
		try {
			if(this.userService.login(dto))
			{
				Cookie cookie = new Cookie("email", dto.getEmail());
				session.setAttribute("email", dto.getEmail());
				session.setAttribute("username",this.userService.getUser(dto.getEmail()).getUsername() );
				resp.addCookie(cookie);
				return "redirect:dashboard";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "redirect:login?error=Invalid credentials";
		}
		// failure => redirect (GET)
		return "redirect:login?error=Invalid credentials";
	}
}
