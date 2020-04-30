import { EmbarqueDTO } from './embarque.dto'
import { PageContent } from './page-content/page.content.dto';
export class FuncionarioDTO{

    id : string;
    nome : string;
    cpf : string;
    cargo : string;
    empresa : string;
    gerente : string;
    estadoFuncionario : string;

    constructor(){
        this.id = "";
        this.nome = "";
        this.cpf  = "";
        this.empresa;
        this.gerente = "";
        this.estadoFuncionario = "";
    }

}