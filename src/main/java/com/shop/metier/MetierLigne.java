package com.shop.metier;

import java.util.List;

import com.shop.dao.DaoLigneCommande;
import com.shop.dao.IDao;
import com.shop.model.LigneCommande;

public class MetierLigne implements IMetier<LigneCommande> {

	IDao<LigneCommande> dLigne = new DaoLigneCommande();
	@Override
	public List<LigneCommande> getAll() {
		return dLigne.getAll();
	}

	@Override
	public LigneCommande getOne(int id) {
		return dLigne.getOne(id);
	}

	@Override
	public boolean create(LigneCommande obj) {
		return dLigne.save(obj);
	}

	@Override
	public boolean update(LigneCommande obj) {
		return dLigne.update(obj);
	}

	@Override
	public boolean delete(LigneCommande obj) {
		return dLigne.delete(obj);
	}

}
