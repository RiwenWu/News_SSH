package com.wrw.sshNews.dao;

import java.util.List;

import com.wrw.sshNews.model.User;

public interface UserDao{

	public boolean isUserExists(User u);
	
	public User findById(Long userId);
	
	public List<User> findUserPage(int newPage, int pageSize);
	
	public void add(User u);
}
