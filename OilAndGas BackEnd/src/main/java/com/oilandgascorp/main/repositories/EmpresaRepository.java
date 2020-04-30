package com.oilandgascorp.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.oilandgascorp.main.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

	@Transactional(readOnly=true)
	public Empresa findByNome(String nome);

	@Transactional(readOnly=true)
	@Query("Select obj.nome From Empresa obj")
	public List<String> findAllEmpresaName();


}
