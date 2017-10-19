package resources;

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

import skiworld.persistence.Client;
import skiworld.persistence.EventHolder;
import skiworld.persistence.Instructor;
import skiworld.persistence.RestaurantManager;
import skiworld.persistence.SkiMan;
import skiworld.persistence.User;
import skiworld.services.IHandelUser;

@Path("users")
@RequestScoped
public class UserResource {
	@EJB
	private IHandelUser handelUser;
public static User user;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		return Response.ok(handelUser.getUser()).build();
	}

	@Path("client")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addClient(Client client) {
		handelUser.addClient(client);
		return "Client added successfully";
	}
	@Path("skiMan")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSkiMan	(SkiMan skiman) {
		handelUser.addSkiMan(skiman);
		return "skiMan added successfully";
	}
	
	@Path("instructor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSkiMan	(Instructor instructor) {
		handelUser.addInstructor(instructor);
		return "instructor added successfully";
	}
	
	@Path("eventHolder")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSkiMan	(EventHolder eventHolder) {
		handelUser.addEventHolder(eventHolder);
		return "eventHolder added successfully";
	}
	
	@Path("restaurantManager")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSkiMan	(RestaurantManager restaurantManager) {
		handelUser.addRestaurantManager(restaurantManager);
		return "restaurantManager added successfully";
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id){

			handelUser.removeUserById(id);
			return Response.status(Status.OK).entity("The user number :"+id+" was deleted successfully !").build();
		
	}
	@PUT
	@Path("client")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(Client c){
		handelUser.updateUser(c);
		return Response.ok().build();
	}
}
