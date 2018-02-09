package com.naman.demorest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("restaurant")
public class RestaurantResources {
	
	
	RestaurantRepository repo = new RestaurantRepository(); 
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Restaurant> getRestaurant(){
		
		System.out.println("get Restaurant called");
		
		
		return repo.getRestaurant();
		}
	
	@GET
	@Path("Singlerestaurant/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Restaurant getRestaurant(@PathParam("id") int id){
		
		System.out.println("get single Restaurant called");
		
		System.out.println(id);
		return repo.getrestaurant(id);
		}
	
	
	@POST
	@Path("restaurantput")
	public Restaurant CreateRestaurant(Restaurant a1)
	 {	
		System.out.println(a1);
		repo.createRestaurant(a1);
		return a1;
	 }
	
	@POST
	@Path("restaurantputmenu")
	public Restaurant CreateRestaurantmenu(Restaurant a1)
	 {	
		System.out.println(a1);
		repo.createRestaurantMenu(a1);
		return a1;
	 } 
	
	@PUT
	@Path("restaurantput")
	public Restaurant updateRestaurant(Restaurant a1)
	 {	
		System.out.println(a1);
		repo.UpdateRestaurant(a1);
		return a1;
	 } 
	
	@PUT
	@Path("restaurantputmenu")
	public Restaurant updateRestaurantmenu(Restaurant a1)
	 {	
		System.out.println(a1);
		repo.UpdateRestaurantmenu(a1);
		return a1;
	 }
	
	
	
	@DELETE
	@Path("restaurantput/{id}")
	public Restaurant deleteRestaurant(@PathParam("id") int id)
	{
		Restaurant a1 = repo.getrestaurant(id);
		if(a1.getID()!=0)
		{
		repo.deleteRestaurant(id);
		}
		return a1;
	}

}
