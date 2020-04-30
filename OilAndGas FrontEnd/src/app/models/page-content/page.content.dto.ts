import { FuncionarioDTO } from '../funcionario.dto';
import { Pageable } from './pageable';
import { Sort } from './sort';

export class PageContent{
    content : any[];
    pageable : Pageable;
    totalPages : number;
    totalElements : Number;
    last : Boolean;
    size : Number;
    number : Number;
    sort : Sort;
    numberOfElements : Number;
    first : Boolean;
    empty : Boolean;

    constructor(pageContent : PageContent){
        this.content = pageContent.content;
        this.pageable = pageContent.pageable;
        this.totalPages = pageContent.totalPages;
        this.totalElements =  pageContent.totalElements;
        this.last = pageContent.last;
        this.size =  pageContent.size;
        this.number =  pageContent.number;
        this.sort = pageContent.sort;
        this.numberOfElements = pageContent.numberOfElements;
        this.first = pageContent.first;
        this.empty = pageContent.empty;
    }

}