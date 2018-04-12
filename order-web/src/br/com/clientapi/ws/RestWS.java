package br.com.clientapi.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.clientapi.entity.Client;
import br.com.clientapi.entity.Order;
import br.com.clientapi.service.ClientRemote;
import br.com.clientapi.service.ClientService;
import br.com.clientapi.service.OrderService;

//http://hostname:port/order-web/rest/api/createOrder
//http://hostname:port/order-web/rest/api/searchOrder
//http://hostname:port/order-web/rest/api/listClient
//http://hostname:port/order-web/rest/api/searchClient
//http://hostname:port/order-web/rest/api/get
@Path("/api")
public class RestWS {

	@POST
	@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/createOrder")
	public String createOrderPost(List<Order> orderList) {
		
		try {
			
			OrderService os = new OrderService();
			
			return os.processOrderList(orderList);
		} catch (Throwable t) {
			return t.getMessage();
		}
	}
	
	@POST
	@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/searchOrder")
	public List<Order> searchOrderPost(Order order) {
		
		try {
			OrderService os = new OrderService();
			return os.searchOrder(order);
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			return null;
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/listClient")
	public List<Client> listClientPost() {

		ClientRemote cs = new ClientService();
        
		return cs.listClient();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/searchClient")
	public List<Client> searchClientPost() {

		ClientService cs = new ClientService();
        
		return cs.listClient();
	}

	@GET
	@Path("/get")
	public String doGet() {

		System.out.println("****it works*****");
        
		return "Ok";
	}
	
}
