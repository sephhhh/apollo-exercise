import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllVehicles } from './view-all-vehicles';

describe('ViewAllVehicles', () => {
  let component: ViewAllVehicles;
  let fixture: ComponentFixture<ViewAllVehicles>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewAllVehicles]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewAllVehicles);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
