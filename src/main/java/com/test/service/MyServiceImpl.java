package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDAO;
import com.test.entity.User;

@Service
public class MyServiceImpl implements MyService {
	
	@Autowired
	private UserDAO userDao;

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	@Override
	public List<User> listUser() {
		return userDao.list();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public User findUser(long id) {
		return userDao.find(id);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteUser(long id) {
		userDao.delete(id);
	}

}