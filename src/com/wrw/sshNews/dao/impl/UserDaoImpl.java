package com.wrw.sshNews.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wrw.sshNews.dao.UserDao;
import com.wrw.sshNews.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

	@Override
	public boolean isUserExists(User u) {
		Transaction tx = this.getCurrentSession().beginTransaction();
		User u1 = null;
		try {
			String hql = "from User u where u.userName=? and u.userPwd=?" ;
			Query query = this.getCurrentSession().createQuery(hql);
			query.setParameter(0, u.getUserName());  
	        query.setParameter(1, u.getUserPwd());
	        u1 = (User) query.uniqueResult();
	        List list = query.list();  
	        if(list==null||list.size()==0){  
	            return false;
	        } 
	        tx.commit();
		} catch(Exception e){
            if(null!=tx){tx.rollback();}
            e.printStackTrace();
        } 
		return true;
	}

	@Override
	public User findById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserPage(int newPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(User u) {
		Transaction tx = this.getCurrentSession().beginTransaction();
		
		//先判断用户名是否唯一
		String hql = "from User u where u.userName=?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, u.getUserName());
		List list = query.list();  
		if(list != null||list.size() > 0){  
            throw new RuntimeException("用户名已存在");  
        }
		
		try {
			this.getCurrentSession().save(u);
			tx.commit();
		} catch(Exception e){
            if(null!=tx){tx.rollback();}
            e.printStackTrace();
        } 
	}


	
}
