package com.example.employeemanager.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id_employer;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private String adresse;

	private String telephone;

	private String grade; 
	
	private String nom;

	private String prenom;

	@ManyToMany
	private Collection<Roles>roles;
    
	@ManyToMany
	private Collection<Departement>departements;
    
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(Long id_employer, String username, String password, String adresse, String telephone, String grade,
			String nom, String prenom, Collection<Roles> roles, Collection<Departement> departements) {
		super();
		this.id_employer = id_employer;
		this.username = username;
		this.password = password;
		this.adresse = adresse;
		this.telephone = telephone;
		this.grade = grade;
		this.nom = nom;
		this.prenom = prenom;
		this.roles = roles;
		this.departements = departements;
	}



	public Long getId_employer() {
		return id_employer;
	}



	public void setId_employer(Long id_employer) {
		this.id_employer = id_employer;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Collection<Roles> getRoles() {
		return roles;
	}



	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}



	public Collection<Departement> getDepartements() {
		return departements;
	}



	public void setDepartements(Collection<Departement> departements) {
		this.departements = departements;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Employee [id_employer=" + id_employer + ", username=" + username + ", password=" + password
				+ ", adresse=" + adresse + ", telephone=" + telephone + ", grade=" + grade + ", nom=" + nom
				+ ", prenom=" + prenom + ", roles=" + roles + ", departements=" + departements + "]";
	}

	
}
