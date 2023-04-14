package bookStore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import bookStore.entity.Book;
import bookStore.entity.User;
import bookStore.repository.UserRepo;
import bookStore.service.BookService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserRepo repo;

	@GetMapping("/home")
	public String homePage(HttpServletRequest request, Map<String,List<Book>> map) {
		System.out.println("Home controller entered");
		List<Book> books = this.bookService.getAllBooks();
		System.out.println(books);
		//map.addAttribute("books", books);
		//List<User> users = this.repo.getUsers();
		//System.out.println(users);
		//map.put("firstBook", "this is example book");
		map.put("books", books);
		return "home";
	}
	
	@GetMapping("/")
	public String indexPage(HttpServletRequest request, Map<String,List<Book>> map) {
		System.out.println("Home controller entered");
		List<Book> books = this.bookService.getAllBooks();
		System.out.println(books);
		//map.addAttribute("books", books);
		//List<User> users = this.repo.getUsers();
		//System.out.println(users);
		//map.put("firstBook", "this is example book");
		map.put("books", books);
		return "index";
	}
}
