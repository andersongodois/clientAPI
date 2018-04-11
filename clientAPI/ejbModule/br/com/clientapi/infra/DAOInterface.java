package br.com.clientapi.infra;

import javax.persistence.EntityManager;

public interface DAOInterface {
	void initialize();
	void setEntityManager(EntityManager em);
}