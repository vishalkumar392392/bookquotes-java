package com.book.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.modal.BookModel;
import com.book.service.BookService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("book")
	public String addBook(@RequestBody BookModel book) {
		
		return bookService.save(book);
	}
	
	@GetMapping("book")
	public List<BookModel> getAllBooks() {
		
		return bookService.getAllBooks();
	}
	
	@GetMapping("/addQuote")
	public String addQuote(@RequestParam(name = "id") int id ,@RequestParam(name = "quote") String quote ) {
		return bookService.addQuote(id,quote);
	}
	
	@DeleteMapping("/removeQuote/{quote}")
	public  List<BookModel> removeQuote(@PathVariable(value = "quote") String quote){
		return bookService.removeQuote(quote);
	}

}
