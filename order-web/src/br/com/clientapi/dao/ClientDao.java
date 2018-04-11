package br.com.clientapi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.clientapi.entity.Client;
import br.com.clientapi.infra.DAO;

@Stateless
@Remote(ClientDaoRemote.class)
public class ClientDao implements ClientDaoRemote {

	@PersistenceContext(unitName = "store-dao")
	private EntityManager em;
	private DAO<Client> dao;

	@Override
	@PostConstruct
	public void initialize() {
		dao = new DAO<Client>(Client.class, em);
	}

	@Override
	public void setEntityManager(EntityManager em) {
		em = this.em;
	}

	@Override
	public void saveClient(Client client) throws Throwable {
		dao.save(client);
	}

	@Override
	public List<Client> listClient() throws Throwable {
		return dao.getList();
	}

	@Override
	public List<Client> searchClient(Client client) throws Throwable {
		Map<Object,Object> params = new HashMap<Object,Object>();
		params.put("controlId", client.getId());
		params.put("clientId", client.getName());
		return dao.findWithNamedQuery("searchClient", params);
	}

}
