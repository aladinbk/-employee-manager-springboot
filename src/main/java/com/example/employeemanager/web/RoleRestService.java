package com.example.employeemanager.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.employeemanager.model.Roles;
import com.example.employeemanager.repository.RolesRepository;



@CrossOrigin("*")
@RestController
public class RoleRestService {
	@Autowired
	private RolesRepository rolesrep;
	
	//Find All Roles
		@RequestMapping(value="/role",method=RequestMethod.GET)
		public List<Roles> getrole(){
			 List<Roles> r=rolesrep.findAll();
			 return r;	
		}
		
	//Save Role
		@RequestMapping(value="/addrole",method=RequestMethod.POST)
		public Roles save(@RequestBody Roles r){
		return rolesrep.save(r);
		}
		
		
	
	
}
