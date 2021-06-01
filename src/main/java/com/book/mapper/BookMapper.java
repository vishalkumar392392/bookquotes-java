package com.book.mapper;

import org.mapstruct.Mapper;

import com.book.commons.mapper.OneToOneMapper;
import com.book.entity.Book;
import com.book.modal.BookModel;

@Mapper(componentModel = "spring")
public interface BookMapper extends OneToOneMapper<BookModel, Book> {

	

}
