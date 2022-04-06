package com.example.employeemanager.web;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepo;
import com.example.employeemanager.services.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeRestService {
	@Autowired
	private EmployeeRepo emplrep;
	@Autowired
	private EmployeeService service;
	
	//Get nbemployees
		@RequestMapping(value="/nbempl",method=RequestMethod.GET)
		public long nbemp(){
			return emplrep.count();
		}

	//Login
	@PostMapping("/login") 
	public Employee loginEmpl(@RequestBody Employee employee) throws Exception{
		String username = employee.getUsername();
		String password = employee.getPassword();
		Employee empObj = null;
		if (username !=null && password !=null) {
			empObj = service.fetchEmployeeByUsernameAndPassword(username, password);
		}
		if(empObj == null) {
			throw new Exception("Bad Request");
		}
		return empObj;
	}
	
	
	//Find Employee page with name
	@RequestMapping(value="/chercherEmp",method=RequestMethod.GET)
	public Page<Employee> chercher(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size){
		return emplrep.chercher("%"+mc+"%",PageRequest.of(page, size));
	}
	
	//Find All Employees
	@RequestMapping(value="/employees",method=RequestMethod.GET)
	public List<Employee> getEmployees(){
		return emplrep.findAll();
	}
	
	//Find ByID Employee
	@RequestMapping(value="/employees/{id_employer}",method=RequestMethod.GET)
	public Optional<Employee> getOneEmployee(@PathVariable Long id_employer){
		return emplrep.findById(id_employer);
	}
	
	//Save Employee
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public Employee save(@RequestBody Employee e){
	return emplrep.save(e);
	}
	
	//DELETE Employee
	@RequestMapping(value="/suppemployee/{id_employer}",method=RequestMethod.DELETE)
	public boolean Suprimer(@PathVariable Long id_employer){
	emplrep.deleteById(id_employer);
	return true;
	}
	
	//Update Employee
	@RequestMapping(value="/modemployeer/{id_employer}",method=RequestMethod.PUT)
	public Employee mod(@RequestBody Employee e, @PathVariable Long id_employer){
	e.setId_employer(id_employer);
	return emplrep.save(e);
	}
	

}
