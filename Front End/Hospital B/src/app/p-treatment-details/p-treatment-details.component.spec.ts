import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PTreatmentDetailsComponent } from './p-treatment-details.component';

describe('PTreatmentDetailsComponent', () => {
  let component: PTreatmentDetailsComponent;
  let fixture: ComponentFixture<PTreatmentDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PTreatmentDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PTreatmentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
