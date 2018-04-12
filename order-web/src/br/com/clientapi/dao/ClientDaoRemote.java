package br.com.clientapi.dao;

import java.util.List;

import br.com.clientapi.entity.Client;
import br.com.clientapi.infra.DAOInterface;

public interface ClientDaoRemote extends DAOInterface {

	void saveClient(Client client) throws Throwable;

	List<Client> listClient() throws Throwable;

	List<Client> searchClient(Client client) throws Throwable;
	
	Client findClientById(int id) throws Throwable;

}