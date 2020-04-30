export class CadastroDesembarqueDTO{
    idEmbarque : number;
    dataDesembarque :  string;
    horaDesembarque :  string;

    constructor(){
        this.idEmbarque = 0;
        this.dataDesembarque = "";
        this.horaDesembarque = "";
    }
  }