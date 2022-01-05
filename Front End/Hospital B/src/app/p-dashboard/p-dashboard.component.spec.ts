import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PDashboardComponent } from './p-dashboard.component';

describe('PDashboardComponent', () => {
  let component: PDashboardComponent;
  let fixture: ComponentFixture<PDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
