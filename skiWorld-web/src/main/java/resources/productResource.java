
package resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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

import skiworld.persistence.Product;
import skiworld.services.IShopManager;


@Path("/product")
@RequestScoped
public class productResource {
	
//public List<Product>product=new ArrayList<Product>();
@EJB
 private IShopManager shopManager ;
@POST
@Consumes(MediaType.APPLICATION_JSON)

public String addProduct(Product product){
	shopManager.AddProduct(product);
return " Product added successfully !";
}




@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Product>listProduct(){
List<Product> list =shopManager.ListProduct();
if(list == null || 
list.isEmpty()){
return null;
}
return list;
}
@GET
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public Response getProducts(){
	return Response.ok(shopManager.ListProduct()).build();
	}





@GET  @Produces(MediaType.APPLICATION_JSON)
@Path("/{id}") 
public List<Product> findProduct(@PathParam("id") Integer id){   
	if(id != null){  
		List<Product> liste = new ArrayList<Product>();
Product product = shopManager.findProduct(id);   
	if(product != null){  
		liste.add(product);  
		return liste;    }   
	return null;     }  
	return shopManager.ListProduct();     } 




@DELETE 
@Path("/{id}") 
public Response deleteProductByid(@PathParam("id") Integer id)
{
	shopManager.deleteProductById(id);
		 
		return Response.status(Status.OK).entity("Your product is associated with  : "+id+" has been successfully removed!").build();      
	  
	}

//@DELETE 
//
//public Response deleteProduct(Product product)
//{
//shopManager.DeleteProduct(product);
//return Response.status(Status.OK).entity("Votre produit a ete supprime avec succes !").build();    
//}

@PUT
@Consumes(MediaType.APPLICATION_JSON)

public String updateProduct(Product product){
	shopManager.UpdateProduct(product);
return " Product updated successfully !";
}
}




