package com.nagarro.hrmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nagarro.hrmanager.model.Employee;
import com.nagarro.hrmanager.model.User;


@Controller
public class HomeController {

	SpringRestClient client = new SpringRestClient();
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("edit")
	public String showEditPage(@RequestParam int id, Model m) {
		Employee emp = client.getEmployee(id);
		m.addAttribute("mode", "edit");
		m.addAttribute("emp", emp);
		return "edit-form";
	}
	
	@GetMapping("add")
	public String showAddPage(Model m) {
		m.addAttribute("mode", "add");
		return "edit-form";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("ecode") int ecode, @RequestParam("name") String name, @RequestParam("loc") String loc,
			@RequestParam("email") String email, @RequestParam("dob") String dob, Model m) {
		
		Employee emp = new Employee(name, loc, email, dob);
		emp.setEcode(ecode);
		
		client.updateEmployee(emp);
		
		m.addAttribute("list", client.empList());
		return "home-page";
	}
	
	@PostMapping("addemp")
	public String add(@RequestParam("name") String name, @RequestParam("loc") String loc,
			@RequestParam("email") String email, @RequestParam("dob") String dob, Model m) {
		
		Employee emp = new Employee(name, loc, email, dob);
		client.addEmployee(emp);
		
		m.addAttribute("list", client.empList());
		return "home-page";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "index";
	}

	@PostMapping("login")
	public String getUser(@RequestParam String username, @RequestParam String password, Model m) {
		User user = client.getUser(username, password);
		
		

		if (user != null) {
			m.addAttribute("list", client.empList());
			m.addAttribute("name", user.getFirstName());
			return "home-page";
		} else {
			
			m.addAttribute("error", "Invalid Username Or Password");
			return "index";
		}
		
	}
	
}
