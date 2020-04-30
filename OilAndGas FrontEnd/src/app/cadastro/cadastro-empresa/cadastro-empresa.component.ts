import { Component, OnInit } from "@angular/core";
import {
  trigger,
  state,
  style,
  animate,
  transition
} from "@angular/animations";
import { EmpresaService } from "../../services/empresa.service";
import { EmpresaDTO } from 'src/app/models/empresa.dto';

@Component({
  selector: "app-cadastro-empresa",
  templateUrl: "./cadastro-empresa.component.html",
  styleUrls: ["./cadastro-empresa.component.css"],
  animations: [
    trigger("slideInOut", [
      transition(":enter", [
        style({ transform: "translateY(-100%)" }),
        animate("700ms ease-in", style({ transform: "translateY(0%)" }))
      ]),
      transition(":leave", [
        animate("700ms ease-in", style({ transform: "translateY(-100%)" }))
      ])
    ])
  ]
})
export class CadastroEmpresaComponent implements OnInit {
  empresa : EmpresaDTO = new EmpresaDTO();
  msgSucesso : Array<string> ;
  showMsg: boolean = false;

  constructor(public empresaService: EmpresaService) {}

  ngOnInit() {}

  postEmpresa() {
    this.empresaService.insertEmpresa(this.empresa).subscribe(
      data => {
        this.msgSucesso = new Array();
        this.msgSucesso.push("Empresa Cadastrda com sucesso")
      },
      error => {
        this.msgSucesso = new Array();
        this.msgSucesso.push("Erro ao cadastrar a Empresa, Motivos: ")
        for(var i = 0; i< error.error.errors.length; i++){
          this.msgSucesso.push(error.error.errors[i].defaultMessage)
        }
        console.log(error);
      }
    );
    this.showResponseMsg();
  }

  showResponseMsg() {
    if (this.showMsg) {
      this.showMsg = false;
    } else {
      this.showMsg = true;
    }
  }
}
