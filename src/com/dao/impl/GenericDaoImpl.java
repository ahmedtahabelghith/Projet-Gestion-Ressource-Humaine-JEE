package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.dao.GenericIDao;
import com.util.HibernateUtil;

public class GenericDaoImpl implements GenericIDao {

	private Session hibernateSession;
	private Transaction tx;

	public GenericDaoImpl() {
		hibernateSession = HibernateUtil.currentSession();
	}

	@Override
	public void saveOrUpdate(Object entity) {
		try {
			startOperation();
			hibernateSession.saveOrUpdate(entity);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}

	}

	@Override
	public void delete(Object entity) {
		try {
			startOperation();
			hibernateSession.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}

	}

	@Override
	public List findAll(Class clazz) {
		List objects = null;
		try {
			startOperation();
			Query query = hibernateSession.createQuery("from "
					+ clazz.getName());
			objects = query.list();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public Object findById(Class clazz, Serializable id) {
		Object obj = null;
		try {
			startOperation();
			obj = hibernateSession.get(clazz, id);
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return obj;
	}

	protected void startOperation() throws HibernateException {
		hibernateSession = HibernateUtil.currentSession();
		tx = hibernateSession.beginTransaction();
	}

	protected void handleException(HibernateException e)
			throws DataAccessLayerException {

		tx.rollback();
		throw new DataAccessLayerException(e);

	} 

}
