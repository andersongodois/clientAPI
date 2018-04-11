package br.com.clientapi.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.clientapi.persistence.entity.Order;
import br.com.clientapi.persistence.interfaces.OrderRemote;

public class OrderDAO extends DAO<OrderRemote> implements OrderRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1325372395245316113L;

	public OrderDAO(EntityManager em, Class<OrderRemote> classe) {
		super(em, classe);
	}

	@Override
	public void saveOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> searchOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
