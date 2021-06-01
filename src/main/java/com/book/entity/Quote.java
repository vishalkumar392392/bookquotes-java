package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "quotes")
public class Quote {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "quote")
	private String quote;
	
	@Column(name = "book_id")
	private long bookId; 
}
