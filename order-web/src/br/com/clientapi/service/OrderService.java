package br.com.clientapi.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.clientapi.dao.OrderDaoRemote;
import br.com.clientapi.entity.Client;
import br.com.clientapi.entity.Order;

@Stateless(mappedName="order-web",name="orderService")
public class OrderService implements OrderRemote {
	
	@EJB
	private OrderDaoRemote orderBean;
	
	@PostConstruct
	private void ejbCreate(){
	}
	
	public String processOrderList(List<Order> orderList){
		
		try {
			
			String message = validateOrderList(orderList);
			if (!message.isEmpty()){
				return message;
			}
			
			for (Order order : orderList) {
				if (order.getDate()==null){
					order.setDate(new Date());
				}
				if (order.getProductQuantity()==null){
					order.setProductQuantity(1);
				}
				
				double totalValue = order.getProductValue()*order.getProductQuantity();
				if (order.getProductQuantity()>5 || order.getProductQuantity()<10){
					totalValue = totalValue*0.95;
				} else if (order.getProductQuantity()>=10){
					totalValue = totalValue*0.9;
				}
				order.setTotalValue(totalValue);
				
				orderBean.saveOrder(order);
			}
			
			return "Cadastrado com sucesso.";
		
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			return "ERROR: Erro ao processar lista de pedidos.";
		}
	}
	
	
	private String validateOrderList(List<Order> orderList) {
		
		try {
			if (orderList.size()>10) {
				return "Número máximo de pedidos excedido.";
			}
			
			ClientService cs = new ClientService();
			
			if (orderList.isEmpty()) return "ERROR: Lista de pedido vazia.";
			for (Order order : orderList) {
				if (order.getClient().getId()==null){
					return "ERROR: Cliente não informado.";
				}
				Client client = cs.isClientValid(order.getClient().getId());
				if (client==null){
					return "ERROR: Cliente inválido.";
				}
				order.setClient(client);
				if (order.getProductName()==null){
					return "ERROR: Nome do produto deve ser preenchido.";
				}
				if (order.getProductValue()==null){
					return "ERROR: Valor do produto deve ser preenchido.";
				}
				if (order.getControlId()==null){
					return "ERROR: Número de controle deve ser preenchido.";
				} else if(orderBean.findOrderById(order.getControlId())!=null){
					return "ERROR: Número de controle "+order.getControlId()+" já existe.";
				}
			}
			
			return "";
		
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			return "ERROR: Erro ao processar lista de pedidos.";
		}
	}
	
	public List<Order> searchOrder(Order order){
		try {
			return orderBean.searchOrder(order);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
