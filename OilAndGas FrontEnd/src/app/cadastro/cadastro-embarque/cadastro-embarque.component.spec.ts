import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroEmbarqueComponent } from './cadastro-embarque.component';

describe('CadastroEmbarqueComponent', () => {
  let component: CadastroEmbarqueComponent;
  let fixture: ComponentFixture<CadastroEmbarqueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastroEmbarqueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroEmbarqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
