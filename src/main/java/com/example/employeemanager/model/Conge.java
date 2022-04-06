package com.example.employeemanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Conge implements Serializable{
	@Id 
	@GeneratedValue
	private Long idC;
	private String status;
	private Long id_employer;
	private String type;
	private Date dateDebut;
	private Date dateFin;
	private String description;
	private String dure;
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conge(Long idC, String status, Long id_employer, String type, Date dateDebut, Date dateFin,
			String description, String dure) {
		super();
		this.idC = idC;
		this.status = status;
		this.id_employer = id_employer;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.dure = dure;
	}
	public Long getIdC() {
		return idC;
	}
	public void setIdC(Long idC) {
		this.idC = idC;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId_employer() {
		return id_employer;
	}
	public void setId_employer(Long id_employer) {
		this.id_employer = id_employer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDure() {
		return dure;
	}
	public void setDure(String dure) {
		this.dure = dure;
	}
	@Override
	public String toString() {
		return "Conge [idC=" + idC + ", status=" + status + ", id_employer=" + id_employer + ", type=" + type
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description=" + description + ", dure="
				+ dure + "]";
	}

	
}
