package br.com.clientapi.persistence.dao;

import javax.persistence.EntityManager;
import java.util.List;

public class DAO<T> {
	private final EntityManager em;
	private final Class<T> classe;

	public DAO(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;
	}

	public T search(Integer id) {
		return this.em.getReference(classe, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return em.createQuery("from " + classe.getName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listByNamedQuery(String namedQuery) {
		//TODO: arrumar isso
		return em.createQuery("from " + classe.getName()).getResultList();
	}

	public void save(T t) {
		this.em.persist(t);
	}

	public void remove(T t) {
		this.em.remove(t);
	}
}