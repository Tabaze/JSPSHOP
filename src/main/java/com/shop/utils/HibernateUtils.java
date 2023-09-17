package com.shop.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.shop.model.*;


public class HibernateUtils {
	
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		Configuration config = new Configuration();
		config.configure();
		
		
		config.addAnnotatedClass(Produit.class);
		config.addAnnotatedClass(LigneCommande.class);
		config.addAnnotatedClass(Commande.class);
		config.addAnnotatedClass(Categorie.class);
		config.addAnnotatedClass(User.class);
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
