package es.salesianos.service;

import java.util.List;

public interface Service<T> {

	public void insert(T item);

	public List<T> listAll();

}
