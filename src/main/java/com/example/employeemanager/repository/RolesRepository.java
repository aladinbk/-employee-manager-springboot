package com.example.employeemanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanager.model.Roles;
public interface RolesRepository extends JpaRepository<Roles, Integer>{

}
