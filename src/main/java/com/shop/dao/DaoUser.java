package com.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shop.model.User;
import com.shop.utils.HibernateUtils;


public class DaoUser implements IDao<User> {

	@Override
	public List<User> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<User> cats = s.createQuery("from User").list();

		t.commit();
		s.close();

		return cats;
	}

	@Override
	public boolean save(User obj) {
		try {
			Session s = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			
			s.save(obj);
			
			t.commit();
			s.close();
			
			return true;
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
			return false;
		}
	}

	@Override
	public User getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		User users = session.get(User.class, id);

		t.commit();
		session.close();

		return users;
	}

	@Override
	public boolean update(User obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(User obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
