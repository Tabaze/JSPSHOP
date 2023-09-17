package com.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shop.model.Categorie;
import com.shop.model.Produit;
import com.shop.utils.HibernateUtils;

public class DaoProduit implements IDao<Produit> {

	@Override
	public List<Produit> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<Produit> produits = s.createQuery("from Produit").list();

		t.commit();
		s.close();

		return produits;
	}

	@Override
	public boolean save(Produit obj) {
		try {
			Session s = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			
			s.save(obj);
			System.out.println("1231");
			t.commit();
			s.close();
			
			return true;
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
			return false;
		}
	}

	@Override
	public Produit getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Produit produit = session.get(Produit.class, id);

		t.commit();
		session.close();

		return produit;
	}

	@Override
	public boolean update(Produit obj) {
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
	public boolean delete(Produit obj) {
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
