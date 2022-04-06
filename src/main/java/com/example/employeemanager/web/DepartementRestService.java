package com.example.employeemanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.model.Departement;
import com.example.employeemanager.model.Roles;
import com.example.employeemanager.repository.DepartementRepository;

@CrossOrigin("*")
@RestController
public class DepartementRestService {
	@Autowired
	private DepartementRepository deprep;
	

	//Find All Departements
		@RequestMapping(value="/departements",method=RequestMethod.GET)
		public List<Departement> getdep(){
			 List<Departement> r=deprep.findAll();
			 return r;	
		}
	
	

}
