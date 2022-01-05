import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DLoginComponent } from './d-login.component';

describe('DLoginComponent', () => {
  let component: DLoginComponent;
  let fixture: ComponentFixture<DLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
