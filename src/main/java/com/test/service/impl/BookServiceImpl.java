package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.BookDAO;
import com.test.entity.Book;
import com.test.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	@Override
	public List<Book> listBook() {
		return bookDao.list();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void saveBook(Book book) {
		bookDao.save(book);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	@Override
	public Book findBook(String id) {
		return bookDao.find(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateBook(Book book) {
		bookDao.update(book);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteBook(String id) {
		bookDao.delete(id);
	}

}
