package br.com.clientapi.ws;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import br.com.clientapi.entity.Order;

//http://hostname:port/order-web/rest/api/createOrder
//http://hostname:port/order-web/rest/api/consultOrder
@Path("/api")
public class OrderService extends Application {

	@POST
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/createOrder")
	public String createOrderPost(Order order) {

		System.out.println("****order Details*****");
        System.out.println("Order id: "+order.getControlId());
        
		return "";
	}


}
