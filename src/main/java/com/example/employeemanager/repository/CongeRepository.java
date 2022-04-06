package com.example.employeemanager.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeemanager.model.Conge;




public interface CongeRepository  extends JpaRepository<Conge, Long>{
	
	
	@Query("select cong from Conge cong where cong.status like :x")
	public Page<Conge> chercher(@Param("x")String mc, Pageable pageable);

	@Query("select count(*) from Conge where status=0")
	public Long nbconge();
	
	
	@Query("select cong from Conge cong where cong.id_employer like :x")
	public List<Conge> find_by_id_employer(@Param("x")Long id_employer);
}
