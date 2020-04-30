import { Component, OnInit, ErrorHandler } from '@angular/core';
import {
  trigger,
  state,
  style,
  animate,
  transition
} from "@angular/animations";

import { FuncionarioDTO } from '../../models/funcionario.dto'


import { FuncionarioService } from "../../services/funcionario.service";
import { CargoService } from "../../services/cargo.service";
import { EmpresaService } from "../../services/empresa.service";
import { GerenteService } from "../../services/gerente.service";


@Component({
  selector: 'app-cadastro-funcionario',
  templateUrl: './cadastro-funcionario.component.html',
  styleUrls: ['./cadastro-funcionario.component.css'],
  animations: [
    trigger("slideInOut", [
      transition(":enter", [
        style({ transform: "translateY(-100%)" }),
        animate("500ms ease-in", style({ transform: "translateY(0%)" }))
      ]),
      transition(":leave", [
        animate("500ms ease-in", style({ transform: "translateY(-100%)" }))
      ])
    ])
  ]
})
export class CadastroFuncionarioComponent implements OnInit {

  funcionario : FuncionarioDTO = new FuncionarioDTO();
  cargos : Array<string> = new Array();
  empresas : Array<string> = new Array();
  gerentes : Array<string> = new Array();
  msgSucesso : Array<string>;
  showMsg : boolean = false;

  constructor( 
    private funcionarioService : FuncionarioService,
    public cargoService : CargoService, 
    public empresaService : EmpresaService, 
    public gerenteService : GerenteService
    ) { }

  ngOnInit() {
    this.cargoService.findAllCargoNomes().subscribe(cargos =>{
      this.cargos = cargos;
    },
      error => {
        console.log(error)
      }
    );

    this.empresaService.findAllEmpresasName().subscribe(empresas =>{
      console.log(empresas)
      this.empresas = empresas;
    },
      error => {
        console.log(error)
      }
    );
  }

  //consulta de todos os gerentes de acordo com a empresa escolhida
  onChange(){
    return this.gerenteService.findAllPerCompany(this.funcionario.empresa).subscribe(gerentes => {
      console.log(gerentes)
      this.gerentes = gerentes;
    })
  }

  postFuncionario(){
    this.msgSucesso = new Array();
    this.funcionario.estadoFuncionario = "Desembarcado";
    this.showResponseMsg();
    return this.funcionarioService.cadastroFuncionario(this.funcionario).subscribe(data => {
      this.msgSucesso.push('Funcionário cadastrado com successo')
      console.log("sucesso", data)
    },
    error => {
      this.msgSucesso = new Array();
      this.msgSucesso.push("Erro ao cadastrar o funcionario, Motivos")
      for(var i = 0; i< error.error.errors.length; i++){
        this.msgSucesso.push(error.error.errors[i].defaultMessage)
      }
      
    }
    )
    
  }

  showResponseMsg() {
    if (this.showMsg) {
      this.showMsg = false;
    } else {
      this.showMsg = true;
    }
    console.log(this.showMsg);
  }

}