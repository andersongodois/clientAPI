package br.com.clientapi.dao;

import java.util.List;

import br.com.clientapi.entity.Order;
import br.com.clientapi.infra.DAOInterface;

public interface OrderDaoRemote extends DAOInterface {

	void saveOrder(Order order) throws Throwable;

	Order findOrderById(int id) throws Throwable;

	List<Order> searchOrder(Order order) throws Throwable;

}