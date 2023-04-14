package bookStore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookStore.entity.Book;
import bookStore.entity.LikedBooks;
import bookStore.entity.ReadLater;
import bookStore.service.BookService;
import bookStore.service.LikedBooksService;
import bookStore.service.ReadLaterService;

@Controller
public class DashboardController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ReadLaterService rlService;
	
	@Autowired
	private LikedBooksService lbService;
	
	@GetMapping("/dashboard")
	public String dashboard(Map<String, List<Book>> map) {
		map.put("books", this.bookService.getAllBooks());
		return "dashboard";
	}
	
	@GetMapping("/likedbook/delete")
	public String deleteFromLikedBook(@RequestParam("bookid")Integer bookid, HttpSession session) {
		
		lbService.deleteLb(session.getAttribute("email").toString(),bookid);
		return "redirect:/likedbook/page";
		
	}
	
	@GetMapping("/readlater/delete")
	public String deleteFromReadLater(@RequestParam("bookid")Integer bookid, HttpSession session) {
		
		rlService.deleteLb(session.getAttribute("email").toString(),bookid);
		return "redirect:/readlater/page";
		
	}
	
	@GetMapping("/likedbook/page")
	public String openLikedBooks(Map<String, List<Book>> map, HttpSession session) {
		if(session !=null) {
			if(session.getAttribute("email")!=null) {
		List<Integer> listOfBookId = this.lbService.fetchBookIdForUser(session.getAttribute("email").toString());
		map.put("books",bookService.booksForBookIdsAndEmail(listOfBookId));
			}
		}
		return "likedbooks";
		
	}
	
	@GetMapping("/readlater/page")
	public String openReadLater(Map<String, List<Book>> map, HttpSession session) {
		if(session!=null) {
			if(session.getAttribute("email")!=null) {
		List<Integer> listOfBookId = this.rlService.fetchAllListForUser(session.getAttribute("email").toString());
		
		map.put("books",bookService.booksForBookIdsAndEmail(listOfBookId));
			}
		}
		return "readlater";
	}
	
	@GetMapping("/readlater")
	public String insertInReadLater(@RequestParam("bookid")Integer bookid, HttpSession session) {
		
		ReadLater rl = new ReadLater();
		rl.setBookid(bookid);
		rl.setUseremail(session.getAttribute("email").toString());
		rlService.insert(rl);
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/likedbook")
	public String insertIntoLikedBook(@RequestParam("bookid")Integer bookid, HttpSession session) {
		LikedBooks books = new LikedBooks();
		books.setBookid(bookid);
		books.setUseremail(session.getAttribute("email").toString());
		lbService.insert(books);
		return "redirect:/dashboard";
		
	}
	
	
}
