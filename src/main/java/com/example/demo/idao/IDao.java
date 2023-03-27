package com.example.demo.idao;

import java.util.List;

public interface IDao<T> {

	T save(T o);

	List<T> findall();

	T findbyid(int id);

	void delete(T o);

	void update(T o);

}
