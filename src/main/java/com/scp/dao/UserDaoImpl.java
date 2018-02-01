package com.scp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.scp.Util.HibernateUtil;
import com.scp.model.User;

@Repository
public class UserDaoImpl {

	HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	
	
	public List getAll() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		List list = session.createQuery("from User").list();
		session.close();
		return list;
	}

	public boolean deleteById(int id) {
		Session session = hibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		session.delete(user);
		tx.commit();
		session.close();
		return true;
	}

	public User getUserById(int id) {
		Session session = hibernateUtil.getSessionFactory().openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	public boolean addUser(User u) {
		Session session = hibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(u);
		transaction.commit();
		session.close();
		return true;
	}
}