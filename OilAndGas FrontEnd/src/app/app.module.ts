import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { CadastroFuncionarioComponent } from './cadastro/cadastro-funcionario/cadastro-funcionario.component';

import { EmpresaService } from "./services/empresa.service";
import { FuncionarioService } from "./services/funcionario.service";
import { CargoService } from './services/cargo.service';
import { GerenteService } from './services/gerente.service';
import { EmbarqueService } from './services/embarque.service';
import { CadastroEmpresaComponent } from './cadastro/cadastro-empresa/cadastro-empresa.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { PaginacaoComponent } from './paginacao/paginacao.component';
import { ConsultaFuncionarioComponent } from './consulta/consulta-funcionario/consulta-funcionario.component';
import { ConsultaFuncionarioFiltroDataComponent } from './consulta/consulta-funcionario-filtro-data/consulta-funcionario-filtro-data.component';
import { FuncionarioInfoComponent } from './consulta/consulta-funcionario/funcionario-info/funcionario-info.component';
import { ConsultaEmpresaComponent } from './consulta/consulta-empresa/consulta-empresa.component';
import { CadastroEmbarqueComponent } from './cadastro/cadastro-embarque/cadastro-embarque.component';
import { EmbarquesComponent } from './embarques/embarques.component';
import { ConsultaEmbarquesComponent } from './embarques/consulta-embarques/consulta-embarques.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CadastroComponent,
    CadastroFuncionarioComponent,
    CadastroEmpresaComponent,
    ConsultaComponent,
    PaginacaoComponent,
    ConsultaFuncionarioComponent,
    ConsultaFuncionarioFiltroDataComponent,
    FuncionarioInfoComponent,
    ConsultaEmpresaComponent,
    CadastroEmbarqueComponent,
    EmbarquesComponent,
    ConsultaEmbarquesComponent,
  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [EmpresaService, FuncionarioService, CargoService, GerenteService, EmbarqueService],
  bootstrap: [AppComponent]
})
export class AppModule { }
