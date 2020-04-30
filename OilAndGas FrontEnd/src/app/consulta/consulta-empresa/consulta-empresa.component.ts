import { Component, OnInit } from '@angular/core';

import { EmpresaService } from "../../services/empresa.service";
import { EmpresaDTO } from "../../models/empresa.dto";
import { AppConfig } from "../../app-config/app.config"
import { PageContent } from 'src/app/models/page-content/page.content.dto';


@Component({
  selector: 'app-consulta-empresa',
  templateUrl: './consulta-empresa.component.html',
  styleUrls: ['./consulta-empresa.component.css']
})
export class ConsultaEmpresaComponent implements OnInit {

  empresas : PageContent;
  

  constructor(
    public empresaService : EmpresaService
    ) { }

  ngOnInit() {
    this.getAllEmpresas(0);
  }

  getAllEmpresas(page : number){
    return this.empresaService.findAllEmpresas(page).subscribe(empresas =>{
      this.empresas = new PageContent(empresas);
    },
      error =>{
        console.log(error);
      }
    );
  }

  nextPage(){
   
  }

  prevPage(){
    
  }

}