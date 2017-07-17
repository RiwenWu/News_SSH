package com.wrw.sshNews.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.wrw.sshNews.dao.UserDao;
import com.wrw.sshNews.dao.impl.UserDaoImpl;
import com.wrw.sshNews.model.User;
import com.wrw.sshNews.service.UserService;

@ContextConfiguration("classpath:applicationContent.xml")
public class testUerServiceImpl extends AbstractJUnit4SpringContextTests{

	@Resource(name = "userService")
	private UserService userService;
	
	@Test
	public void testSave() {
		User u = new User();
		u.setUserName("a");
		u.setUserPwd("e");
		userService.save(u);
	}
	
	@Test
	public void testLogin(){
		User u1 = new User();
		u1.setUserName("e");
		u1.setUserPwd("f");
		Boolean a = userService.login(u1);
		
		Assert.assertEquals(true, a);
	}

}
