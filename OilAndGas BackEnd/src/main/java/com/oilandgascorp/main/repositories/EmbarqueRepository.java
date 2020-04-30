package com.oilandgascorp.main.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oilandgascorp.main.domain.Embarque;

public interface EmbarqueRepository extends JpaRepository<Embarque, Integer>{
	
	
	@Transactional(readOnly = true)
	@Query("Select e From Embarque e where e.funcionario.id = :idFuncionario")
	Page<Embarque> findAllPaged(org.springframework.data.domain.Pageable pageRequest, @Param("idFuncionario")Integer idFuncionario);
	
	@Transactional(readOnly = true)
	@Query("Select e From Embarque e where e.funcionario.id = :idFuncionario")
	List<Embarque> findAllList(@Param("idFuncionario")Integer idFuncionario);
	

	
}
