package br.com.clientapi.service;

import java.util.List;

import br.com.clientapi.entity.Order;

public interface OrderRemote {
	
	public String processOrderList(List<Order> orderList);
	
	public List<Order> searchOrder(Order order);

}
