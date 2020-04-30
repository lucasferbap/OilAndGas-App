import { Component, OnInit, Output ,EventEmitter } from '@angular/core';
import {
  NgbDate,
  NgbCalendar,
  NgbDateParserFormatter
} from "@ng-bootstrap/ng-bootstrap";
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { PageContent } from 'src/app/models/page-content/page.content.dto';


@Component({
  selector: 'app-consulta-funcionario-filtro-data',
  templateUrl: './consulta-funcionario-filtro-data.component.html',
  styleUrls: ['./consulta-funcionario-filtro-data.component.css']
})
export class ConsultaFuncionarioFiltroDataComponent implements OnInit {
  funcionarios : PageContent;
  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;
  @Output() close  = new EventEmitter<boolean>();
  toggleCalendarTable : boolean = true;

  constructor(calendar: NgbCalendar, private funcionarioService : FuncionarioService) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), "d", 10);
   }

  ngOnInit(): void {
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

  filtrarFuncionarios(page : number) {
    let startDay = this.fromDate.day < 10 ? "0" + this.fromDate.day : this.fromDate.day.toString();
    let startMonth = this.fromDate.month < 10 ? "0" + this.fromDate.month.toString() : this.fromDate.month.toString();
    let startDate = `${this.fromDate.year.toString()}-${startMonth}-${startDay}T00:00:00`;

    let endDay = this.toDate.day < 10 ? "0" + this.toDate.day : this.toDate.day.toString();
    let endMonth = this.toDate.month < 10 ? "0" + this.toDate.month.toString() : this.toDate.month.toString();
    let endDate = `${this.toDate.year.toString()}-${endMonth}-${endDay}T23:59:59`;

    this.getAllFuncionarios(`/funcionarios?page=${page}&dataInicio=${startDate}&dataFim=${endDate}`);
    this.toggleCalendarTable ? this.toggleCalendarTable = false : this.toggleCalendarTable = true 

  }


  onDateSelection(date: NgbDate) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && date.after(this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  isHovered(date: NgbDate) {
    return (
      this.fromDate &&
      !this.toDate &&
      this.hoveredDate &&
      date.after(this.fromDate) &&
      date.before(this.hoveredDate)
    );
  }

  isInside(date: NgbDate) {
    return date.after(this.fromDate) && date.before(this.toDate);
  }

  isRange(date: NgbDate) {
    return (
      date.equals(this.fromDate) ||
      date.equals(this.toDate) ||
      this.isInside(date) ||
      this.isHovered(date)
    );
  }

  closeComponent(){
    this.close.emit(false);
  }

}
