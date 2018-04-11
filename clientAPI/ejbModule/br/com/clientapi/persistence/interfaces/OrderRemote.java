package br.com.clientapi.persistence.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.clientapi.persistence.entity.Order;

public interface OrderRemote extends Serializable {

	void saveOrder();
	List<Order> searchOrder();
	
}