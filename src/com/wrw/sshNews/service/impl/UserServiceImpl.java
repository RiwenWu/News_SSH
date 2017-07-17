package com.wrw.sshNews.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wrw.sshNews.dao.UserDao;
import com.wrw.sshNews.model.User;
import com.wrw.sshNews.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }
	
	@Override
	public void save(User u) {
		userDao.add(u);
	}

	@Override
	public boolean login(User u) {
		return userDao.isUserExists(u);
	}


}
