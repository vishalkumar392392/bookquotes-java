package com.book.modal;

import java.util.List;

import lombok.Data;

@Data
public class BookModel {

	private int id;
	
	private String bookName;
	
	private List<String> quotes;
	
	
	
}
