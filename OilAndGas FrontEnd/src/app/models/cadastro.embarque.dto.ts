export class CadastroEmbarqueDTO{
    idFuncionario : number;
    dataEmbarque :  string;
    horaEmbarque :  string;

    constructor(){
        this.idFuncionario = 0;
        this.dataEmbarque = "";
        this.horaEmbarque = "";
    }
  }