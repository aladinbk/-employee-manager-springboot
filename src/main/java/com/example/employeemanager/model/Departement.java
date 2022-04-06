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
public class Departement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id_departement;
	private String nom_departement;
	@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "departements")    
    private Collection<Employee>employees;
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(int id_departement, String nom_departement, Collection<Employee> employees) {
		super();
		this.id_departement = id_departement;
		this.nom_departement = nom_departement;
		this.employees = employees;
	}
	public int getId_departement() {
		return id_departement;
	}
	public void setId_departement(int id_departement) {
		this.id_departement = id_departement;
	}
	public String getNom_departement() {
		return nom_departement;
	}
	public void setNom_departement(String nom_departement) {
		this.nom_departement = nom_departement;
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
		return "Departement [id_departement=" + id_departement + ", nom_departement=" + nom_departement + ", employees="
				+ employees + "]";
	}
	
	

	
}
