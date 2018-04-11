package br.com.clientapi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.clientapi.entity.Order;
import br.com.clientapi.infra.DAO;

@Stateless
@Remote(OrderDaoRemote.class)
public class OrderDao implements OrderDaoRemote {

	@PersistenceContext(unitName = "store-dao")
	private EntityManager em;
	private DAO<Order> dao;

	@Override
	@PostConstruct
	public void initialize() {
		dao = new DAO<Order>(Order.class, em);
	}

	@Override
	public void setEntityManager(EntityManager em) {
		em = this.em;
	}

	@Override
	public void saveOrder(Order order) throws Throwable {
		dao.save(order);
	}

	@Override
	public Order findOrderById(int id) throws Throwable {
		return dao.search(id);
	}

	@Override
	public List<Order> searchOrder(Order order) throws Throwable {
		Map<Object,Object> params = new HashMap<Object,Object>();
		params.put("controlId", order.getControlId());
		params.put("date", order.getDate());
		params.put("procuctName", order.getProductName());
		params.put("productValue", order.getProductValue());
		params.put("productQuantity", order.getProductQuantity());
		params.put("totalValue", order.getTotalValue());
		params.put("clientId", order.getClient().getId());
		return dao.findWithNamedQuery("searchOrder", params);
	}

}
