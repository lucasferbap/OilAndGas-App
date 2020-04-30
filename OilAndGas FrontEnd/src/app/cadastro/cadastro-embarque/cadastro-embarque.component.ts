import {
  Component,
  OnInit,
  Input,
  Output,
  EventEmitter,
  OnDestroy
} from "@angular/core";
import {
  trigger,
  state,
  style,
  animate,
  transition
} from "@angular/animations";
import { NgbDateStruct, NgbCalendar } from "@ng-bootstrap/ng-bootstrap";
import { ActivatedRoute } from '@angular/router';


import { EmbarqueService } from "../../services/embarque.service";
import { CadastroEmbarqueDTO } from 'src/app/models/cadastro.embarque.dto';
import { CadastroDesembarqueDTO } from 'src/app/models/cadastro.desembarque.dto';

@Component({
  selector: "app-cadastro-embarque",
  templateUrl: "./cadastro-embarque.component.html",
  styleUrls: ["./cadastro-embarque.component.css"],
  // animação entrada lateral do cadastro de embarques
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
export class CadastroEmbarqueComponent implements OnInit, OnDestroy {

  cadastroEmbarque : CadastroEmbarqueDTO = new CadastroEmbarqueDTO();
  cadastroDesembarque : CadastroDesembarqueDTO = new CadastroDesembarqueDTO();
  idEmbarque : number
  idFuncionario : number
  embarqueOuDesembarque : string // true - > embarque, false -> desembarque
  nomeFuncionario : string = "";
  responseMsg : Array<string>;
  animateResponseMsg : boolean = false;
  model: NgbDateStruct;
  date: { year: number; month: number };
  time = { hour: 13, minute: 30 };
  openClose : boolean = false;

   constructor(
    private calendar: NgbCalendar,
    private embarqueService: EmbarqueService,
    private route : ActivatedRoute
  ) {
    this.model = this.calendar.getToday();
  }

  ngOnDestroy() {
  }

  ngOnInit() {
    let now = new Date();
    this.time.hour = now.getHours();
    this.time.minute = now.getMinutes();
    this.route.queryParams.subscribe(data => {
      this.idFuncionario = data.idFuncionario;
      this.idEmbarque = data.idEmbarque;
      this.nomeFuncionario = data.nome;
      this.embarqueOuDesembarque =  data.embarqueOuDesembarque;
      console.log(typeof(data.embarqueOuDesembarque))
    });
    this.openClose = true
  }

  postEmbarque( cadastroEmbarque : CadastroEmbarqueDTO){
    this.responseMsg = new Array();
    return this.embarqueService.postEmbarque(cadastroEmbarque).subscribe(data => {
      this.responseMsg.push("Embarque Cadastrado com Sucesso")
      console.log("Funcionou", data)
    }, 
      error =>{        
        console.log(error);
        for(var i = 0; i < error.error.errors.length; i++){
          this.responseMsg.push(error.error.errors[i].message);
        }
      }
    )
  }

  putEmbarques( cadastroDesembarque : CadastroDesembarqueDTO , idEmbarque : number){
    this.responseMsg = new Array();
    return this.embarqueService.putEmbarque(cadastroDesembarque, idEmbarque).subscribe(data => {
      this.responseMsg.push("Desembarque Cadastrado com Sucesso")
      console.log("Funcionou", data)
    }, 
      error =>{        
        console.log(error);
        for(var i = 0; i < error.error.errors.length; i++){
          this.responseMsg.push(error.error.errors[i].message);
        }
      }
    )
  }

  parseStringCadastroEmbarque() {
    if(this.embarqueOuDesembarque == "true"){
      this.cadastroEmbarque.dataEmbarque = `${this.model.year}-${
        this.model.month < 10 ? "0" + this.model.month : this.model.month
      }-${this.model.day < 10 ? "0" + this.model.day : this.model.day}`;

      this.cadastroEmbarque.horaEmbarque = `${
        this.time.hour < 10 ? "0" + this.time.hour : this.time.hour
      }:${
        this.time.minute < 10 ? "0" + this.time.minute : this.time.minute
      }:00`;
    }else if(this.embarqueOuDesembarque == "false"){
      this.cadastroDesembarque.dataDesembarque = `${this.model.year}-${
        this.model.month < 10 ? "0" + this.model.month : this.model.month
      }-${this.model.day < 10 ? "0" + this.model.day : this.model.day}`;

      this.cadastroDesembarque.horaDesembarque = `${
        this.time.hour < 10 ? "0" + this.time.hour : this.time.hour
      }:${
        this.time.minute < 10 ? "0" + this.time.minute : this.time.minute
      }:00`;
    }
  }

  cadastrarEmbarque(){
    this.parseStringCadastroEmbarque();
    if(this.embarqueOuDesembarque == "true"){
      this.cadastroEmbarque.idFuncionario = this.idFuncionario;
      this.postEmbarque(this.cadastroEmbarque)
    }else if(this.embarqueOuDesembarque == "false"){
      this.cadastroDesembarque.idEmbarque = this.idEmbarque;
      this.putEmbarques(this.cadastroDesembarque, this.idEmbarque);
    }
    
  }

  toggleResponseMsg(){
    this.animateResponseMsg ? this.animateResponseMsg = false : this.animateResponseMsg = true;
  }

  toggleOpenClose(){
    this.openClose ? this.openClose = false : this.openClose = true;
  }

}
