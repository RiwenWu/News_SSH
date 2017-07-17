package com.wrw.sshNews.dao.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.wrw.sshNews.dao.UserDao;
import com.wrw.sshNews.model.User;

@ContextConfiguration("classpath:applicationContent.xml")
public class testUserDaoImpl extends AbstractJUnit4SpringContextTests{

	@Resource(name = "userDao")
	private UserDao userDao;
	
	@Test
	public void testAdd() {
		User u = new User();
		u.setUserName("f");
		u.setUserPwd("e");
		userDao.add(u);
	}
	
	@Test
	public void testIsUserExists() {
		User u1 = new User();
		User u2 = new User();
		u1.setUserName("e");
		u1.setUserPwd("f");
		Boolean a = userDao.isUserExists(u1);
		
		Assert.assertEquals(true, a);
	}

}
