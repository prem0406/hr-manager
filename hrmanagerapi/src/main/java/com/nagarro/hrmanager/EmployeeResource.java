package com.nagarro.hrmanager;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.nagarro.hrmanager.model.Employee;
import com.nagarro.hrmanager.repository.EmployeeRepo;



@Path("emp")
public class EmployeeResource {
EmployeeRepo repo = new EmployeeRepo();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Employee> getEmployees() {
		 
		return repo.getEmployees();
	}
	
	@POST
	@Path("addemp")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee addEmployee(Employee emp) {
		System.out.println(emp);
		repo.addEmployee(emp);
		return emp;
	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateEmployee(Employee emp) {
		
		System.out.println(emp);
		repo.updateEmpoyee(emp);
		
		return Response.ok().entity(emp).build();
	}
	
	@GET
	@Path("getemp/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getEmployee(@PathParam("id") int id) {
		

		if (id <= 0 ) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Employee emp = repo.getEmployee(id);
		
		if (emp == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(emp).build();
	}
	
	@GET
	@Path("delete/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deleteEmployee(@PathParam("id") int id) {
		
		if (id <= 0 ) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Employee emp = repo.getEmployee(id);
		
		
		if (emp == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		repo.deleteEmpoyee(id);
		
		return Response.ok().entity(emp).build();
	}
	

}
