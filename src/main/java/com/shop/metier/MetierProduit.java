package com.shop.metier;

import java.util.List;

import com.shop.dao.DaoProduit;
import com.shop.dao.IDao;
import com.shop.model.Produit;

public class MetierProduit implements IMetier<Produit> {

	IDao<Produit> dProduit = new DaoProduit();
	@Override
	public List<Produit> getAll() {
		return dProduit.getAll();
	}

	@Override
	public Produit getOne(int id) {
		return dProduit.getOne(id);
	}

	@Override
	public boolean create(Produit obj) {
		return dProduit.save(obj);
	}

	@Override
	public boolean update(Produit obj) {
		return dProduit.update(obj);
	}

	@Override
	public boolean delete(Produit obj) {
		return dProduit.delete(obj);
	}

}
