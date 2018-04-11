package br.com.clientapi.infra;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAO<T> {

	private EntityManager em;
	private final Class<T> clazz;

	public DAO(Class<T> clazz, EntityManager em) {
		this.em = em;
		this.clazz = clazz;
	}

	public T save(T t) throws Throwable {
		try {
			t = em.merge(t);
			return t;
		} catch (Throwable e) {
			throw e;
		}
	}

	public T delete(T t) throws Throwable {
		try {
			em.remove(t);
			return t;
		} catch (Throwable e) {
			throw e;
		}
	}

	public T search(Integer id) throws Throwable {
		try {
			T t = em.getReference(clazz, id);
			return t;
		} catch (Throwable e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() throws Throwable {
		try {
			return em.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t").getResultList();
		} catch (Throwable e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findWithNamedQuery(String namedQueryName) throws Throwable {
		try {
			return this.em.createNamedQuery(namedQueryName).getResultList();
		} catch (Throwable e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNativeQuery(String sql, Class<T> type) throws Throwable {
		try {
			return this.em.createNativeQuery(sql, type).getResultList();
		} catch (Throwable e) {
			throw e;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByNativeQuery(String sql) throws Throwable {
		try {
			return this.em.createNativeQuery(sql).getResultList();
		} catch (Throwable e) {
			throw e;
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public List<T> findWithNamedQuery(String namedQueryName, Map<Object, Object> parameters) throws Throwable {

		String attributes = "";
		try {

			Set<Entry<Object, Object>> rawParameters = parameters.entrySet();
			Query query = this.em.createNamedQuery(namedQueryName);

			for (Iterator<Entry<Object, Object>> iterator = rawParameters.iterator(); iterator.hasNext();) {

				Entry<Object, Object> entry = (Entry<Object, Object>) iterator.next();
				query.setParameter(entry.getKey().toString(), entry.getValue());
				attributes += "(key: " + entry.getKey().toString() + " value: " + entry.getValue() + ") |";
			}

			return query.getResultList();

		} catch (Throwable e) {
			throw e;
		}
	}

	public Integer executeNamedQuery(final String namedQuery) throws Throwable {
		try {
			return this.em.createQuery(namedQuery).executeUpdate();
		} catch (Throwable e) {
			throw e;
		}
	}

	public EntityManager getEntityManager() {
		return em;
	}

}
