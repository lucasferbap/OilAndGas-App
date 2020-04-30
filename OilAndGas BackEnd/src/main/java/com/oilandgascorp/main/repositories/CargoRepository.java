package com.oilandgascorp.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.oilandgascorp.main.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{
	
	@Transactional(readOnly=true)
	public Cargo findByNome(String nome);

	@Transactional(readOnly=true)
	@Query("Select obj.nome from Cargo obj")
	public List<String> findAllCargoName();

}
