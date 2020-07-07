package com.spring2.services;

import java.util.List;
import com.byteslounge.spring.tx.model.User;

public interface ProvaService {
	
	void insertUser(User user);

	List<User> findAllUsers();

}
