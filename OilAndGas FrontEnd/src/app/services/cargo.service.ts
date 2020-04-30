import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


import { AppConfig } from './../app-config/app.config';

@Injectable()
export class CargoService {

  constructor(public http: HttpClient) { }

  findAllCargoNomes() : Observable<string[]>{
    return this.http.get<string[]>(`${AppConfig.url}cargos`);
  }

}