import { Component, OnInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-paginacao',
  templateUrl: './paginacao.component.html',
  styleUrls: ['./paginacao.component.css']
})
export class PaginacaoComponent implements OnInit, OnDestroy {

  @Input() numeroPaginas: number;
  paginaAtualDisplay: number = 1;
  paginaAtualRequest: number = 0;
  @Output() paginaClicada = new EventEmitter<number>();
  arrayPaginas: Array<number> = new Array();
  activePrevArrow : boolean = false;
  activeNextArrow : boolean = true;


  constructor() { }

  ngOnDestroy(){
    this.numeroPaginas = 0;
    console.log("Fechando : numero de paginas : ", this.numeroPaginas)
  }

  ngOnInit() {
    //preenchendo o array de páginas
    console.log("ABrindo, numero de paginas: ",this.numeroPaginas)
    for (var i = 0; i < this.numeroPaginas; i++) {
      this.arrayPaginas.push(i);

    }
    console.log(this.arrayPaginas)
    
  }

  emitirPaginaClicada(page: number) {
    this.paginaAtualRequest = page
    this.paginaAtualDisplay = page + 1;
    this.paginaClicada.emit(this.paginaAtualRequest);
    this.toggleArrow();
  }

  toggleArrow(){
    if(this.paginaAtualDisplay >= this.numeroPaginas){
      this.activeNextArrow ? this.activeNextArrow = false : this.activeNextArrow = true;
    }else if(this.paginaAtualDisplay > 1 && this.paginaAtualDisplay < this.numeroPaginas){
      this.activeNextArrow = true;
      this.activePrevArrow = true;
    }
    else if(this.paginaAtualDisplay <= 1){
      this.activePrevArrow ? this.activePrevArrow = false : this.activePrevArrow = true;
    }
  }

  prevNextPage(direction: string) {
    if (direction == "next") {
      this.paginaAtualRequest++;
      this.paginaAtualDisplay++;
      this.toggleArrow();
    } else if (direction == 'prev') {
      this.paginaAtualRequest--;
      this.paginaAtualDisplay--;
      this.toggleArrow();
    }
    this.paginaClicada.emit(this.paginaAtualRequest);
    
  }

}



