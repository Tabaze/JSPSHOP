package com.shop.metier;

import java.util.List;

import com.shop.dao.DaoCommande;
import com.shop.dao.IDao;
import com.shop.model.Commande;

public class MetierCommande implements IMetier<Commande> {

	IDao<Commande> dCom = new DaoCommande();
	@Override
	public List<Commande> getAll() {
		return dCom.getAll();
	}

	@Override
	public Commande getOne(int id) {
		return dCom.getOne(id);
	}

	@Override
	public boolean create(Commande obj) {
		return dCom.save(obj);
	}

	@Override
	public boolean update(Commande obj) {
		return dCom.update(obj);
	}

	@Override
	public boolean delete(Commande obj) {
		return dCom.delete(obj);
	}

}
