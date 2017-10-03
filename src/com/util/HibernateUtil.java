package com.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	public static String CONFIG_FILE_LOCATION = "com/util/hibernate.cfg.xml";
	static {
		try {
			Configuration cfg = new AnnotationConfiguration();
			sessionFactory = cfg.configure(CONFIG_FILE_LOCATION)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal threadLocal = new ThreadLocal();

	public static Session currentSession() throws HibernateException {

		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {

			if (sessionFactory == null) {
				try {
					 Configuration cfg = new AnnotationConfiguration();
					 sessionFactory = cfg.configure(CONFIG_FILE_LOCATION)
					 .buildSessionFactory();
				} catch (Exception e) {
					System.err.println("Error Creating SessionFactory ");
					e.printStackTrace();
				}
			}

			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}

		return session;
	}

	public static void closeSession() throws HibernateException {
		sessionFactory.close();
	}

}
