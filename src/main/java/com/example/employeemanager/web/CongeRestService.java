package com.example.employeemanager.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.model.Conge;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.CongeRepository;

@RestController
@CrossOrigin("*")
public class CongeRestService {
	@Autowired
	private CongeRepository congerep;
	
	//Find Conge page with employer
	@RequestMapping(value="/chercherconge",method=RequestMethod.GET)
	public Page<Conge> chercher(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size){
		return congerep.chercher("%"+mc+"%",PageRequest.of(page, size));
	}
	
	
	
	
	//Get nbconge
	@RequestMapping(value="/nbconges",method=RequestMethod.GET)
	public Long nbconges(){
		return congerep.nbconge();
	}
	
	//POST
	@RequestMapping(value = "/conge", method = RequestMethod.POST)
	public Conge SaveConge(@RequestBody Conge c) {
		return congerep.save(c);
	}
	
	//Find BYId
	@GetMapping("/conge/{idC}")
	public ResponseEntity<Conge> getCongeById(@PathVariable(value = "idC") Long idC)
	 throws ResourceNotFoundException {
	 Conge conge = congerep.findById(idC)
	   .orElseThrow(() -> new ResourceNotFoundException("Client not found for this idC :: " + idC));
	 return ResponseEntity.ok().body(conge);
	}
	
	//Find Conge per id_employer
	@RequestMapping(value="/conger/{id_employer}",method=RequestMethod.GET)
	public List<Conge> getcongeperid_employer(@PathVariable Long id_employer){
		return congerep.find_by_id_employer(id_employer);
	}
	
	
	//Find All Conges
	@RequestMapping(value="/congietes",method=RequestMethod.GET)
	public List<Conge> getconges(){
		return congerep.findAll();
	}
	
	//Update Conge
	@RequestMapping(value="/modconge/{idC}",method=RequestMethod.PUT)
	public Conge modifier(@RequestBody Conge c, @PathVariable Long idC){
	c.setIdC(idC);
	return congerep.save(c);
	}
	
	//DELETE Conge	
	@RequestMapping(value="/suppconge/{idC}",method=RequestMethod.DELETE)
	public boolean Suprimer(@PathVariable Long idC){
	congerep.deleteById(idC);
	return true;
	}
	
}
