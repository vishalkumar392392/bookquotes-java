package com.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.modal.BookModel;

@Service
public interface BookService {
	
	String save(BookModel bookModel);
	
	List<BookModel> getAllBooks();

	String addQuote(int id, String quote);

	List<BookModel> removeQuote(String quote);
}
