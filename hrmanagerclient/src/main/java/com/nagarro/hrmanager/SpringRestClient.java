package com.nagarro.hrmanager;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import com.nagarro.hrmanager.model.Employee;
import com.nagarro.hrmanager.model.User;

public class SpringRestClient {
	
	private static final String BASE_URI="http://localhost:8080/hrmanagerapi/webapi";
	

	public Client client;
	
	
	
	public SpringRestClient() {
		client = ClientBuilder.newClient(); 
	}

	
	public List<Employee> empList() {
		WebTarget target = client.target(BASE_URI);
		List<Employee> emplist = target.path("/emp").request().get(new GenericType<List<Employee>>() {});
		return emplist;
		
	}
	
	public Employee addEmployee(Employee emp) {
		WebTarget target = client.target(BASE_URI);
		Response response = target.path("/emp/addemp").request()
				.post(Entity.entity(emp,javax.ws.rs.core.MediaType.APPLICATION_JSON));
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was en error while fetching record");
			
		}
		
		return response.readEntity(Employee.class);
	}
	
	public Employee updateEmployee(Employee emp) {
		WebTarget target = client.target(BASE_URI);
		Response response = target.path("/emp/update").request()
				.put(Entity.entity(emp,javax.ws.rs.core.MediaType.APPLICATION_JSON));
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was en error while fetching record");
			
		}
		
		return response.readEntity(Employee.class);
	}
	
	public Employee deleteEmployee(int id) {
		WebTarget target = client.target(BASE_URI);
		Response response = target.path("/emp/delete/"+id).request().get(Response.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was en error while fetching record");
			
		}
		
		return response.readEntity(Employee.class);
	}
	
	public Employee getEmployee(int id) {
	
			
			WebTarget target = client.target(BASE_URI);
			Response response = target.path("/emp/getemp/" + id).request().get(Response.class);
			
			if (response.getStatus() != 200) {
				throw new RuntimeException(response.getStatus() + ": there was en error while fetching record");
				
			}
			
			return response.readEntity(Employee.class);
		}
	
	public User getUser(String u, String p) {
		WebTarget target = client.target(BASE_URI);
		
		Response response = target.path("/user/getUser/" + u +"/"+ p).request().get(Response.class);
		
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was en error while fetching record");
			
		}
		
		return response.readEntity(User.class);
	}
}
