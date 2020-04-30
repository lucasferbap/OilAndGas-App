import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { GerenteDTO } from '../models/gerente.dto';

import { AppConfig } from './../app-config/app.config';

@Injectable()
export class GerenteService {

  constructor(public http: HttpClient) { }

  findAllPerCompany(nomeEmpresa : string) : Observable<string[]>{
    return this.http.get<string[]>(`${AppConfig.url}gerentes?nomeEmpresa=${nomeEmpresa}`);
  }

}