import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


import { EmbarqueDTO } from './../models/embarque.dto';
import { AppConfig } from "./../app-config/app.config"
import { PageContent } from '../models/page-content/page.content.dto';
import { CadastroEmbarqueDTO } from '../models/cadastro.embarque.dto';
import { CadastroDesembarqueDTO } from '../models/cadastro.desembarque.dto';

@Injectable()
export class EmbarqueService {



  constructor(public http: HttpClient) { }


  // retorna todos os embarques de um funcionario
  getAllEmbarquesPorFuncionariogetAllEmbarquesPorFuncionario(id : number, page : number) : Observable<PageContent>{
    return this.http.get<PageContent>(`${AppConfig.url}embarques/funcionarios/${id}?page=${page}`)
  }

  // cadastra um embarque
  postEmbarque( cadastroEmbarque : CadastroEmbarqueDTO) : Observable<CadastroEmbarqueDTO>{
    return this.http.post<CadastroEmbarqueDTO>(`${AppConfig.url}embarques`, cadastroEmbarque);
  }

  //atualiza um embarque
  putEmbarque ( cadastroDesembarque : CadastroDesembarqueDTO, idEmbarque : number ) : Observable<CadastroDesembarqueDTO>{
    console.log(cadastroDesembarque)
    return this.http.put<CadastroDesembarqueDTO>(`${AppConfig.url}embarques/${idEmbarque}`, cadastroDesembarque);
  }

}