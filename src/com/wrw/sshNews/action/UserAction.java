package com.wrw.sshNews.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wrw.sshNews.dto.UserInfo;
import com.wrw.sshNews.model.User;
import com.wrw.sshNews.service.UserService;

@Component("userAction")
public class UserAction extends ActionSupport implements ModelDriven{

	private UserInfo userInfo = new UserInfo();
	@Autowired
	private UserService userService;
	private User user;
	
	public UserAction(){
		System.out.println("UserAction create");
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}
	
	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUserName(userInfo.getUserName());
		u.setUserPwd(userInfo.getUserPassword());
		if(!userService.login(u)){
			return "fail";
		}
		return "success";
	}

}
