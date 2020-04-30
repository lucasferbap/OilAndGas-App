import { Component, OnInit } from '@angular/core'; 
import { ActivatedRoute } from '@angular/router';

import { FuncionarioDTO } from '../../../models/funcionario.dto';

import { FuncionarioService } from '../../../services/funcionario.service';
import { EmbarqueService } from 'src/app/services/embarque.service';
import { EmbarqueDTO } from 'src/app/models/embarque.dto';
import { PageContent } from 'src/app/models/page-content/page.content.dto';


@Component({
  selector: 'app-funcionario-info',
  templateUrl: './funcionario-info.component.html',
  styleUrls: ['./funcionario-info.component.css']
})
export class FuncionarioInfoComponent implements OnInit {

  id : number;
  funcionario : FuncionarioDTO;
  embarques : PageContent;

  constructor(
    private route : ActivatedRoute, 
    private funcionarioService : FuncionarioService,
    private embarqueService : EmbarqueService 
  ) { }

  ngOnInit() {
    this.route.queryParams.subscribe(id => {
      this.id = id.id;
    });
    this.getFuncionario();
    this.getEmbarques(0);
  }

  getFuncionario(){
    return this.funcionarioService.findFuncionario(this.id).subscribe(funcionario => {
      console.log(funcionario)
      this.funcionario = funcionario;
    },
      error => {
        console.log(error);
      }
    )
  }

  getEmbarques(page : number){
      return this.embarqueService.getAllEmbarquesPorFuncionariogetAllEmbarquesPorFuncionario(this.id, page).subscribe(embarques => {
        this.embarques = new PageContent(embarques);
      }, 
      error => {
        console.log(error);
      })
  }

}