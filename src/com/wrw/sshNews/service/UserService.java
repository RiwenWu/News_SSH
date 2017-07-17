package com.wrw.sshNews.service;

import com.wrw.sshNews.model.User;

public interface UserService {

	void save(User u);
	
	boolean login(User u);
}
