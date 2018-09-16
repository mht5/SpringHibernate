package com.test.service;

import java.util.List;

import com.test.entity.Book;

public interface BookService {
	
	List<Book> listBook();

	void saveBook(Book book);

	Book findBook(String id);

	void updateBook(Book book);

	void deleteBook(String id);

}
