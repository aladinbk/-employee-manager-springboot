package com.example.employeemanager.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id_roles;
	
	private String nom_roles;
	@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles")    
    private Collection<Employee>employees;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int id_roles, String nom_roles, Collection<Employee> employees) {
		super();
		this.id_roles = id_roles;
		this.nom_roles = nom_roles;
		this.employees = employees;
	}

	public int getId_roles() {
		return id_roles;
	}

	public void setId_roles(int id_roles) {
		this.id_roles = id_roles;
	}

	public String getNom_roles() {
		return nom_roles;
	}

	public void setNom_roles(String nom_roles) {
		this.nom_roles = nom_roles;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Roles [id_roles=" + id_roles + ", nom_roles=" + nom_roles + ", employees=" + employees + "]";
	}
	
    
	
	
	
}
