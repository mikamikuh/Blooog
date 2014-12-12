package com.mikamikuh.blooog.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Criterion;

public interface AbstractDAO<E, I extends Serializable> {

	E findById(I userName);

	void saveOrUpdate(E e);

	void delete(E e);

	List<E> findByCriteria(Criterion criterion);
}
