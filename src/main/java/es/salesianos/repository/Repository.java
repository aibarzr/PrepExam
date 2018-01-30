package es.salesianos.repository;

import java.util.List;

public interface Repository<T> {
	void insert(T item);
	List<T> listAll();
}
