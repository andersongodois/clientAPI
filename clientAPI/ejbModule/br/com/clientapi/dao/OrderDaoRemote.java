package br.com.clientapi.dao;

import java.util.List;

import br.com.clientapi.entity.Order;
import br.com.clientapi.infra.DAOInterface;

public interface OrderDaoRemote extends DAOInterface {

	void saveOrder(Order order) throws Throwable;

	Order findOrderById() throws Throwable;

	List<Order> searchOrder() throws Throwable;

	List<Order> findByNativeQuery(String sql, Class<Order> type) throws Throwable;

}