import { Component, OnInit } from '@angular/core';
import {
  trigger,
  state,
  style,
  animate,
  transition
} from "@angular/animations";
import { FuncionarioService } from '../services/funcionario.service';
import { PageContent } from '../models/page-content/page.content.dto';

@Component({
  selector: 'app-embarques',
  templateUrl: './embarques.component.html',
  styleUrls: ['./embarques.component.css'],
  animations: [
    trigger("fly", [
      state("true", style({ transform: "translateX(0)" })),
      transition("void => *", [
        style({ transform: "translateX(-100%)" }),
        animate(200)
      ]),
      transition("* => void", [
        animate(200, style({ transform: "translateX(100%)" }))
      ])
    ])
  ]
})
export class EmbarquesComponent implements OnInit {

  funcionarios : PageContent
  openClose : boolean = false;
  constructor( private funcionarioService : FuncionarioService) { }

  ngOnInit(): void {
    this.findAllFuncionariosNomeId(0);
    this.openClose = true;
  }

  findAllFuncionariosNomeId( page : number){
    return this.funcionarioService.findAllFuncionariosNomeId(page).subscribe( funcionarios => {
      this.funcionarios = new PageContent(funcionarios);
    },
      error => {
        console.log(error);
        
      }
    )
  }

}
