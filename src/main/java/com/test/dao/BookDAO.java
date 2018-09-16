package com.test.dao;

import java.util.List;

import com.test.entity.Book;

public interface BookDAO {
	
	List<Book> list();

	void save(Book book);

	Book find(String id);

	void update(Book book);

	void delete(String id);

}
