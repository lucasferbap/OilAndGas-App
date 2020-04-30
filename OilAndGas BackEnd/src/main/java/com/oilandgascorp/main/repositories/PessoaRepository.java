package com.oilandgascorp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oilandgascorp.main.domain.Empresa;
import com.oilandgascorp.main.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
}
