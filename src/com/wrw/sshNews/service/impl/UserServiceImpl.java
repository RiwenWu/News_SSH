package com.wrw.sshNews.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrw.sshNews.dao.UserDao;
import com.wrw.sshNews.model.User;
import com.wrw.sshNews.service.UserService;

@Service("userService")
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
		Transaction ts = null;
		try {
			ts = getCurrentSession().beginTransaction();
			userDao.add(u);
			ts.commit();
		}catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			}
		}
	}

	@Override
	public boolean login(User u) {
		Transaction ts = null;
		try {
			ts = getCurrentSession().beginTransaction();
			if (!userDao.isUserExists(u)){
				ts.rollback();
				return false;
			}
			ts.commit();
		}catch (Exception e) {
			if (ts != null) {
				ts.rollback();
				return false;
			}
		} 

		return true;
	}


}
