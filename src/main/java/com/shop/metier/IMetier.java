package com.shop.metier;

import java.util.List;

public interface IMetier<T>{

	List<T> getAll();
	T getOne(int id);
	boolean create(T obj);
	boolean update(T obj);
	boolean delete(T obj);
}
