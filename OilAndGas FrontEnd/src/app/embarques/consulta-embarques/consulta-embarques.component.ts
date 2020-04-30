import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { ActivatedRoute } from '@angular/router';
import { EmbarqueService } from 'src/app/services/embarque.service';
import { PageContent } from 'src/app/models/page-content/page.content.dto';

@Component({
  selector: 'app-consulta-embarques',
  templateUrl: './consulta-embarques.component.html',
  styleUrls: ['./consulta-embarques.component.css'],
  animations: [
    trigger("animateMsg", [
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
export class ConsultaEmbarquesComponent implements OnInit {

  idFuncionario: number
  nomeFuncionario: string = "";
  openClose: boolean = false;
  cadastrarEmbarque: boolean;
  embarques: PageContent

  constructor(private route: ActivatedRoute, private embarqueService: EmbarqueService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(data => {
      this.idFuncionario = data.id;
      this.nomeFuncionario = data.nome;
    });
    this.findAllEmbarques(0);
    this.openClose = true;
  }

  findAllEmbarques(page: number) {
    return this.embarqueService.getAllEmbarquesPorFuncionariogetAllEmbarquesPorFuncionario(this.idFuncionario, page).subscribe(embarques => {
      this.embarques = new PageContent(embarques);
      console.log(embarques)
      this.cadastrarEmbarque = this.podeCadastrarEmbarque();
    },
      error => {
        console.log(error);
      }
    )
  }

  toggleOpenClose() {
    this.openClose ? this.openClose = false : this.openClose = true;
  }

  podeCadastrarEmbarque(): boolean {
    if (this.embarques.content.length == 0) {
      return true
    } else if (this.embarques.content.slice(-1)[0].dataDesembarque == null) {
      return false
    } else if (!(this.embarques.content.slice(-1)[0].dataDesembarque == null)) {
      return true;
    }
  }

}
