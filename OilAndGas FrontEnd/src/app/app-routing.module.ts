import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from '../app/home/home.component';

import { CadastroComponent } from './cadastro/cadastro.component';
import { CadastroFuncionarioComponent } from './cadastro/cadastro-funcionario/cadastro-funcionario.component';
import { CadastroEmpresaComponent } from './cadastro/cadastro-empresa/cadastro-empresa.component';

import { ConsultaComponent } from './consulta/consulta.component';
import { ConsultaFuncionarioComponent } from './consulta/consulta-funcionario/consulta-funcionario.component';
import { FuncionarioInfoComponent } from './consulta/consulta-funcionario/funcionario-info/funcionario-info.component';
import { ConsultaEmpresaComponent } from './consulta/consulta-empresa/consulta-empresa.component';

import { EmbarquesComponent } from './embarques/embarques.component';
import { CadastroEmbarqueComponent } from './cadastro/cadastro-embarque/cadastro-embarque.component';
import { ConsultaEmbarquesComponent } from './embarques/consulta-embarques/consulta-embarques.component';





const routes: Routes = [
  { path : 'home', component : HomeComponent },

  { path: 'cadastro', component: CadastroComponent},
  { path: 'cadastro/funcionarios', component: CadastroFuncionarioComponent},
  { path: 'cadastro/empresas', component: CadastroEmpresaComponent },

  { path: 'consulta', component: ConsultaComponent},
  { path: 'consulta/empresas', component: ConsultaEmpresaComponent},
  { path: 'consulta/funcionarios', component: ConsultaFuncionarioComponent},
  { path: 'consulta/info/funcionarios', component: FuncionarioInfoComponent},

  { path: 'embarques', component: EmbarquesComponent},
  { path: 'embarques/consulta', component: ConsultaEmbarquesComponent},
  { path: 'embarques/cadastro', component: CadastroEmbarqueComponent},


  { path: '**', redirectTo: '/home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
