package com.nagarro.hrmanager;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nagarro.hrmanager.model.User;
import com.nagarro.hrmanager.repository.UserRepo;

@Path("user")
public class UserResource {
	
	UserRepo repo = new UserRepo();
	
	@GET
	@Path("getUser/{u: .*}/{p}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getUser(@PathParam("u") String u, @PathParam("p") String p) {
		System.out.println(u + " " +p);
		User user = repo.getUser(u, p);
		
		if (user == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(user).build();
	}
}
