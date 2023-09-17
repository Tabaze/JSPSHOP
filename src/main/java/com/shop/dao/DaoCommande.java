package com.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shop.model.*;
import com.shop.utils.HibernateUtils;

public class DaoCommande implements IDao<Commande> {

	@Override
	public List<Commande> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<Commande> commande = s.createQuery("from Commande").list();

		t.commit();
		s.close();

		return commande;
	}

	@Override
	public boolean save(Commande obj) {
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
	public Commande getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Commande commande = session.get(Commande.class, id);

		t.commit();
		session.close();

		return commande;
	}

	@Override
	public boolean update(Commande obj) {
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
	public boolean delete(Commande obj) {
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
