package br.com.clientapi.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.clientapi.dao.ClientDaoRemote;
import br.com.clientapi.entity.Client;

@Stateless(mappedName="order-web",name="clientService")
public class ClientService implements ClientRemote {
	
	@EJB
	private ClientDaoRemote clientBean;
	
	@PostConstruct
	private void ejbCreate(){
	}
	
	public Client isClientValid(int id){
		try {
			Client client = clientBean.findClientById(id);
			if(client!=null){
				return client;
			} else {
				return null;
			}
		} catch (Throwable t) {
			System.out.println("Erro ao buscar cliente");
			return null;
		}
	}
	
	public List<Client> listClient() {
		try {
			return clientBean.listClient();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Client> searchClient(Client client) {
		try {
			return clientBean.searchClient(client);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
