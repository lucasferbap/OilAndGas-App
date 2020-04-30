package com.oilandgascorp.main.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oilandgascorp.main.domain.Empresa;
import com.oilandgascorp.main.domain.Funcionario;
import com.oilandgascorp.main.domain.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Integer>{
	
	@Transactional(readOnly=true)
	public Gerente findByNome(String gerente);

	@Transactional(readOnly=true)
	@Query(value = "Select p.nome From Pessoa p inner join Gerente g WHERE p.id = g.id_gerente  and p.empresa_id = (SELECT e.id from Empresa e WHERE e.nome = :nomeEmpresa)", nativeQuery = true)
	public List<String> findAllGerentesNamesPorEmpresa(@Param(value = "nomeEmpresa") String nomeEmpresa);
	

}

