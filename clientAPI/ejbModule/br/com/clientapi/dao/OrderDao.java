package br.com.clientapi.dao;

import java.util.List;

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
	public List<Order> searchOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderById() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByNativeQuery(String sql, Class<Order> type) throws Throwable {
		return dao.findByNativeQuery(sql, type);
	}

}
