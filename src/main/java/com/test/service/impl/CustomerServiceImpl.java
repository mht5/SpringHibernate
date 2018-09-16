package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.CustomerDAO;
import com.test.entity.Customer;
import com.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDao;

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	@Override
	public List<Customer> listCustomer() {
		return customerDao.list();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	@Override
	public Customer findCustomer(String id) {
		return customerDao.find(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteCustomer(String id) {
		customerDao.delete(id);
	}

}
