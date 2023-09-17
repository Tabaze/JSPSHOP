package com.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shop.model.Categorie;
import com.shop.utils.HibernateUtils;


public class DaoCategorie implements IDao<Categorie> {

	@Override
	public List<Categorie> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<Categorie> cats = s.createQuery("from Categorie").list();

		t.commit();
		s.close();

		return cats;
	}

	@Override
	public boolean save(Categorie obj) {
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
	public Categorie getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Categorie categorie = session.get(Categorie.class, id);

		t.commit();
		session.close();

		return categorie;
	}

	@Override
	public boolean update(Categorie obj) {
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
	public boolean delete(Categorie obj) {
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
