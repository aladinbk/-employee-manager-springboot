package com.example.employeemanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanager.model.Departement;
public interface DepartementRepository extends JpaRepository<Departement, Integer >{

}
