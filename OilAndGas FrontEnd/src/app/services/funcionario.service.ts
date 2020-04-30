import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { FuncionarioDTO } from '../models/funcionario.dto';

import { AppConfig } from './../app-config/app.config';
import { PageContent } from '../models/page-content/page.content.dto';

@Injectable()
export class FuncionarioService {

  constructor(public http: HttpClient) { }

  findAllFuncionariosNomeId(page : number) : Observable<PageContent>{
    return this.http.get<PageContent>(`${AppConfig.url}funcionarios/nomes?page=${page}`);
  }

  findFuncionario(id : number) : Observable<FuncionarioDTO>{
    return this.http.get<FuncionarioDTO>(`${AppConfig.url}funcionarios/${id}`);
  }

  findAll(url : String) : Observable<PageContent>{
    return this.http.get<PageContent>(`${AppConfig.url}${url}`);
  }

  cadastroFuncionario(funcionario : FuncionarioDTO){
    return this.http.post<FuncionarioDTO>(
     `${AppConfig.url}funcionarios`,
      funcionario
    )
  }
  
  

}