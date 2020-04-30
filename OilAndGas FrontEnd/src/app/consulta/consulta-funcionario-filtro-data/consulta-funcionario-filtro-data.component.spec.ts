import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaFuncionarioFiltroDataComponent } from './consulta-funcionario-filtro-data.component';

describe('ConsultaFuncionarioFiltroDataComponent', () => {
  let component: ConsultaFuncionarioFiltroDataComponent;
  let fixture: ComponentFixture<ConsultaFuncionarioFiltroDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaFuncionarioFiltroDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaFuncionarioFiltroDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
