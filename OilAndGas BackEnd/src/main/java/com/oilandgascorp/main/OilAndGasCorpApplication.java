package com.oilandgascorp.main;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oilandgascorp.main.domain.Cargo;
import com.oilandgascorp.main.domain.Embarque;
import com.oilandgascorp.main.domain.Empresa;
import com.oilandgascorp.main.domain.Funcionario;
import com.oilandgascorp.main.domain.Gerente;
import com.oilandgascorp.main.domain.enuns.EstadoFuncionario;
import com.oilandgascorp.main.repositories.GerenteRepository;
import com.oilandgascorp.main.repositories.FuncionarioRepository;
import com.oilandgascorp.main.repositories.*;

@SpringBootApplication
public class OilAndGasCorpApplication implements CommandLineRunner {

	

	public static void main(String[] args) {
		SpringApplication.run(OilAndGasCorpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}