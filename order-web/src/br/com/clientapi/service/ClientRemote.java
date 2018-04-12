package br.com.clientapi.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.clientapi.entity.Client;

@Remote
public interface ClientRemote {
	
	public Client isClientValid(int id);
	
	public List<Client> listClient();
	
	public List<Client> searchClient(Client client);

}
