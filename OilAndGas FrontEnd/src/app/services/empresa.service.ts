import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { EmpresaDTO } from "./../models/empresa.dto";
import { AppConfig } from "./../app-config/app.config";
import { PageContent } from '../models/page-content/page.content.dto';
//import { CadastroEmpresaDTO } from 'models/cadastro.empresa.dto'

@Injectable()
export class EmpresaService {
  constructor(public http: HttpClient) {}


  findAllEmpresasName() : Observable<string[]>{
    return this.http.get<string[]>(`${AppConfig.url}empresas/nomes`)
  }

  findAllEmpresas(page : number) : Observable<PageContent>{
    return this.http.get<PageContent>(`${AppConfig.url}empresas?page=${page}`)
  }

  insertEmpresa( empresa : EmpresaDTO) : Observable<EmpresaDTO>{
    return this.http.post<EmpresaDTO>(`${AppConfig.url}empresas`, empresa);
  }

  
}
