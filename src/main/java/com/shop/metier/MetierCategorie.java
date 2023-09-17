package com.shop.metier;

import java.util.List;

import com.shop.dao.DaoCategorie;
import com.shop.dao.IDao;
import com.shop.model.Categorie;

public class MetierCategorie implements IMetier<Categorie> {

	IDao<Categorie> dCate = new DaoCategorie();
	@Override
	public List<Categorie> getAll() {
		return dCate.getAll();
	}

	@Override
	public Categorie getOne(int id) {
		return dCate.getOne(id);
	}

	@Override
	public boolean create(Categorie obj) {
		return dCate.save(obj);
	}

	@Override
	public boolean update(Categorie obj) {
		return dCate.update(obj);
	}

	@Override
	public boolean delete(Categorie obj) {
		return dCate.delete(obj);
	}

}
