package com.book.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.entity.Quote;
import com.book.mapper.BookMapper;
import com.book.modal.BookModel;
import com.book.repository.BookRepository;
import com.book.repository.QuoteRepository;
import com.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private QuoteRepository quoteRepository;

	@Autowired
	private BookMapper bookMapper;

	@Override
	public String save(BookModel bookModel) {

		Book boo = bookRepository.save(bookMapper.getDTO(bookModel));
		return Objects.nonNull(boo.getBookName()) ? "Saved Successfully" : null;
	}

	@Override
	public List<BookModel> getAllBooks() {
		List<BookModel> books = bookRepository.findAll().stream().map(bookMapper::getModel)
				.collect(Collectors.toList());
		List<Quote> quotes = quoteRepository.findAll();

		for (BookModel bookModel : books) {
			bookModel.setQuotes(quotes.stream().filter(x -> x.getBookId() == bookModel.getId()).map(Quote::getQuote)
					.collect(Collectors.toList()));
		}
		return books;
	}

	@Override
	public String addQuote(int id, String quote) {
		Quote quoteDTO = new Quote();
		quoteDTO.setBookId(id);
		quoteDTO.setQuote(quote);
		return Objects.nonNull(quoteRepository.save(quoteDTO).getQuote()) ? "Added" : null;
	}

	@Override
	public List<BookModel> removeQuote(String quote) {
		quoteRepository.deleteByQuote(quote);
		return getAllBooks();
	}

}
