export class EmbarqueDTO{
    idEmbarque : string;
    idFuncionario : string;
    dataEmbarque :  string;
    horaEmbarque :  string;
    dataDesembarque :  string;
    horaDesembarque :  string;

    constructor(){
        this.idEmbarque = "";
        this.idFuncionario = "";
        this.dataEmbarque = "";
        this.horaEmbarque = "";
        this.dataDesembarque = "";
        this.horaDesembarque = "";
    }
  }