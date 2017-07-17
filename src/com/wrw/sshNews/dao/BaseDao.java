package com.wrw.sshNews.dao;

import java.util.List;

public interface BaseDao<T, PK> {
	
	public List<T> getAllObjects(Class<T> entityClass);
	
	public T getObjectById(Class<T> entityClass, PK id);
	
	public void loadObjectId(Class<T> entityClass, PK id);
	
	public void saveObject(T entity);
	
	public void delectObject(PK id);
	
	public void updateObject(T entity);
	
}
