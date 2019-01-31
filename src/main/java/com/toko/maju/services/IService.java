package com.toko.maju.services;

import java.util.Set;

public interface IService<T, ID> {
	public T save(T entity);

	public T findById(ID id);

	public T updateById(ID id, T entity);

	public void delete(T entity);

	public void deleteById(ID id);

	public Set<T> getAll();
}
