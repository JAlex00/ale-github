package com.spring2.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.byteslounge.spring.tx.dao.UserDAO;
import com.byteslounge.spring.tx.model.User;
import com.spring2.services.ProvaService;

@Service
public class ProvaServiceImpl implements ProvaService{
	
	@Autowired
	private UserDAO userDAO;


	@Transactional
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}


	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}

}
