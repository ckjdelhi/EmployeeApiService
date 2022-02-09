package com.test.EmployeeApiService;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class EmployeeController {
	static ArrayList<String> list=new ArrayList<String>();
	static {
		list.add("IBM");
		list.add("Oracle");
		list.add("Google");
		list.add("Meta");
		list.add("NIIT");
	}
	//@GetMapping("/")
	@RequestMapping(value = "/getcompanyname", method = RequestMethod.GET)
	public String getCompanyName() {
		return "Google";
	}
	
	@RequestMapping(value = "/get-all-names", method = RequestMethod.GET)
	public List<String> getAllNames() {
		return list;
	}
	@RequestMapping(value = "/get-employee", method = RequestMethod.GET)
	public Employee getEmployee() {
		Employee obj = new Employee(100, "Chandan", "Kumar");
		return obj;
	}
	
	//@PostMapping("/url")
	@RequestMapping(value = "/add-company", method = RequestMethod.POST)
	public String addCompany(@RequestBody String name) {
		list.add(name);
		return "Successfully Added to the list";
	}
	
	@RequestMapping(value = "/delete-company/{name}", method = RequestMethod.DELETE)
	public String deleteCompany(@PathVariable String name) {
		if(list.contains(name)) {
			list.remove(name);
		}
		return "Successfully deleted from the list";
	}
}
