package com.example.employeemanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.employeemanager.model.Conge;
import com.example.employeemanager.model.Employee;
@CrossOrigin("*")
@RepositoryRestResource
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	public  Employee findByUsernameAndPassword(String username, String password);
	
	@Query("select emp from Employee emp  where emp.nom like :x")
	public Page<Employee> chercher(@Param("x")String mc, Pageable pageable);
	

	@Query("select emp from Employee emp  where emp.nom like :x")
	public List<Employee> find_by_nom(@Param("x")String nom);
	
	/*@Query("select emp from Employee emp  where emp.nom_utilisateur like :x")
	 public List<Employee> find_by_nom_utilisateur(@Param("x")String nom_utilisateur);*/
	

	@Query(" select nom from Employee ")
	public List<String> empl_nom();
	
	
	@Query("select count(*) from Employee")
	public List<Employee> nbemp();
	
	
	/*@Query("select id_employer from Employee  where nom_utilisateur like :x")
	public Long get_id(@Param("x")String nom_utilisateur);*/

}
