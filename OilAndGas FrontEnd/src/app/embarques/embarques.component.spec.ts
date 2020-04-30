import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmbarquesComponent } from './embarques.component';

describe('EmbarquesComponent', () => {
  let component: EmbarquesComponent;
  let fixture: ComponentFixture<EmbarquesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmbarquesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmbarquesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
