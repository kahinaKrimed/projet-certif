package appliAngular.dao;

import java.util.List;

public interface DaoGeneric<T,PK> {
	T find(PK id);
	List<T> findAll();
	void create(T obj);
	T update(T obj);
	void delete(T obj);
//	void save (T obj);
}

