package com.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shop.model.*;
import com.shop.utils.HibernateUtils;

public class DaoLigneCommande implements IDao<LigneCommande> {

	@Override
	public List<LigneCommande> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<LigneCommande> ligne = s.createQuery("from LigneCommande").list();

		t.commit();
		s.close();

		return ligne;
	}

	@Override
	public boolean save(LigneCommande obj) {
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
	public LigneCommande getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		LigneCommande ligne = session.get(LigneCommande.class, id);

		t.commit();
		session.close();

		return ligne;
	}

	@Override
	public boolean update(LigneCommande obj) {
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
	public boolean delete(LigneCommande obj) {
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
