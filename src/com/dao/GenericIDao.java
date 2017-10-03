package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericIDao {

	public   void saveOrUpdate(Object entity);

	public void delete(Object entity);

	public List findAll(Class clazz);

	public Object findById(Class clazz, Serializable id);
}
