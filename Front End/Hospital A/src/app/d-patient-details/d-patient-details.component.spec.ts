import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DPatientDetailsComponent } from './d-patient-details.component';

describe('DPatientDetailsComponent', () => {
  let component: DPatientDetailsComponent;
  let fixture: ComponentFixture<DPatientDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DPatientDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DPatientDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
