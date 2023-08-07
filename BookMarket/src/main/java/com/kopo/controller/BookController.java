package com.kopo.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kopo.domain.Book;
import com.kopo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	// @RequestMapping(value = "/books", method=RequestMethod.GET)
	// @RequestMapping
	@GetMapping
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}

//	@GetMapping("/all")
//	public String requestAllBooks(Model model) {
//		List<Book> list = bookService.getAllBookList();
//		model.addAttribute("bookList", list);
//		return "books";
//	}

	// map형식
	@GetMapping("/all")
	public ModelAndView requestAllBooks(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		modelAndView.addObject("bookList", list);
		modelAndView.setViewName("books");

		return modelAndView;
	}

	/*
	 * @GetMapping("/exam08/{category}/publisher/{publisher}") public String
	 * requestMethod(@PathVariable String category, => 넘어온 경로변수를 활용
	 */
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		return "books";

	}

	// EX url)
	// localhost:8080/controller/books/filter/bookFilter;publisher=네이버;category=IT전문서
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter,
			Model model) {
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByFilter);
		return "books";
	}

	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}

	@GetMapping("/add")
	// public String requestAddBookForm(Book book) {
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
		/*
		 * 네비게이션 바, jumbotron, footer 적용한 jsp 페이지 만들기 bookid name unitprice author
		 * description <- textarea publisher category unitinstock releaseDate condition
		 * <- radiobutton
		 * 
		 */
		return "addBook";
	}

	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewBook") Book book) {
		MultipartFile bookImage = book.getBookImage();
		
		String saveName = bookImage.getOriginalFilename();
		File saveFile = new File("C:\\upload, saveName");
		
		if(bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(saveFile);
			} catch(Exception e) {
				throw new RuntimeException("이미지 업로드에 실패하였습니다.", e);
			}
		}

		bookService.setNewBook(book);
		return "redirect:/books"; // 뷰 리다이렉션 - 웹 요청에 따라서 뷰페이지 이동

		/*
		 * 1. redirect - 요청 URL로 응답 뷰를 이동 - 이때 이동할 URL에 다시 요청을 시도 -> 최초 요청은 무효 : 폼에서
		 * 데이터를 입력받는 시스템, 세션 DB에 변화가 생가는 요청
		 * 
		 * 2. forward - 최초 요청 URL을 유지 -> 응답 뷰 페이지를 표현 - 현재 페이지에서 이동할 URL로 정보가 그대로 전달 ->
		 * 최초 요청 정보가 유효 - 실제 웹페이지가 변경됐지만 사용자는 알 수 없음 : 시스템 변화가 없는 단순 조회, 등등 사용
		 * 
		 */
	}

	@ModelAttribute
	public void addAttribute(Model model) {
		model.addAttribute("addTitle", "신규 도서 등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", 
				"publisher", "category", "unitsInStock", "releaseDate", "condition", "bookImage");
	}
	


}
