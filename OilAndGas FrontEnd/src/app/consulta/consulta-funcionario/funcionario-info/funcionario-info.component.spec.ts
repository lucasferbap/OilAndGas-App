import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuncionarioInfoComponent } from './funcionario-info.component';

describe('FuncionarioInfoComponent', () => {
  let component: FuncionarioInfoComponent;
  let fixture: ComponentFixture<FuncionarioInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuncionarioInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuncionarioInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
