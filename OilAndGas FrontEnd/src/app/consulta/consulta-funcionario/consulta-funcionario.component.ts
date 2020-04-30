import { Component, OnInit, Input } from "@angular/core";
import {
  trigger,
  state,
  style,
  animate,
  transition
} from "@angular/animations";

import { FuncionarioService } from "../../services/funcionario.service";

import { FuncionarioDTO } from "../../models/funcionario.dto";
import { PageContent } from 'src/app/models/page-content/page.content.dto';
//import { FuncionarioEmbarqueDTO } from '../models/funcionario.embarque.dto';

@Component({
  selector: "app-consulta-funcionario",
  templateUrl: "./consulta-funcionario.component.html",
  styleUrls: ["./consulta-funcionario.component.css"],
  animations: [
    trigger("openCloseTrigger", [
      transition(":enter", [
        style({ opacity: 0 }),
        animate("700ms", style({ opacity: 1 }))
      ]),
      transition(":leave", [animate("700ms", style({ opacity: 0 }))])
    ])
  ]
})
export class ConsultaFuncionarioComponent implements OnInit {
  funcionarios: PageContent;
  datePickerFilter: boolean = false;

  constructor(
    private funcionarioService: FuncionarioService
  ) {}

  ngOnInit() {
    this.getAllFuncionarios("/funcionarios");
  }

  getAllFuncionarios(url: string) {
    return this.funcionarioService.findAll(url).subscribe(
      funcionarios => {
        this.funcionarios = new PageContent(funcionarios);
        console.log(this.funcionarios)
      }, error => {
        console.log(error);
      }
    )
  }

  
  teste(pagina: number) {
    console.log(pagina)
    this.getAllFuncionarios('funcionarios?page=' + pagina)
  }

  toggleDatePickerFilter() {
    this.datePickerFilter ? this.datePickerFilter = false : this.datePickerFilter = true;
  }

  closeDatePicker(close : boolean){
    this.datePickerFilter = close;
  }
}
