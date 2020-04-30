package com.oilandgascorp.main.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oilandgascorp.main.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT func FROM Funcionario func LEFT JOIN Embarque emb on func.id = emb.funcionario.id WHERE emb.dataEmbarque >= :inicio AND emb.dataDesembarque <= :fim")
	Page<Funcionario> findAllComFiltroData(Pageable pageRequest, @Param("inicio") LocalDateTime inicioDecoded, @Param("fim") LocalDateTime fimDecoded);
	

}
