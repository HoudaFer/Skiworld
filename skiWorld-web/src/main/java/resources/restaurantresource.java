package resources;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import skiworld.persistence.Restaurant;
import skiworld.services.IManageRestaurant;

@Path("/restores")
@RequestScoped
public class restaurantresource {
	@EJB
		private IManageRestaurant managerestau;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
		public String addUser (Restaurant restaurant) { 
		managerestau.addRestaurant(restaurant);
		return "added successfully";
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRestaurant() {
		List<Restaurant> r= managerestau.FindRestaurant();
		if (r!=null) {
			return Response.status(Status.OK).entity(r).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	

	@DELETE 
	@Path("/{id}")
	public Response deleteRestaurantByid(@PathParam("id") int id)
	{
		managerestau.deleteRestaurantById(id);
			 
			return Response.status(Status.OK).entity("Restaurant associated with  : "+id+" has been successfully removed!").build();      
		  
		}
	
		
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRestaurant(Restaurant resto) {
			if (managerestau.updateRestaurant(resto))
			return Response.status(Status.OK).build();
			return Response.status(Status.NOT_FOUND).build();
	}
	
}
