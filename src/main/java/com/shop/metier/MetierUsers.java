package com.shop.metier;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.shop.dao.DaoUser;
import com.shop.dao.IDao;
import com.shop.model.User;

public class MetierUsers implements IMetier<User> {

	IDao<User> muser = new DaoUser();

	@Override
	public List<User> getAll() {
		return muser.getAll();
	}

	@Override
	public User getOne(int id) {
		return muser.getOne(id);
	}

	@Override
	public boolean create(User obj) {
		return muser.save(obj);
	}

	@Override
	public boolean update(User obj) {
		return muser.update(obj);
	}

	@Override
	public boolean delete(User obj) {
		return muser.delete(obj);
	}

	public User signin(String username, String password) {
		User user = getAll().stream()
				.filter(x-> x.getUsername().equals(username) && x.getPassword().equals(password))
				.collect(Collectors.toList()).get(0);
		return user;
	}

}
