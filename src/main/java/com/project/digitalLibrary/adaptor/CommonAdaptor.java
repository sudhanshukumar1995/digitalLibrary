package com.project.digitalLibrary.adaptor;

import java.util.List;

public interface CommonAdaptor<E, M> {

	M save(E e);

	M getById(long id);

	List<M> getAll();

	M update(E e);

	void delete(long id);
}
