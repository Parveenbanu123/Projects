import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanPrice } from './plan-price';

describe('PlanPrice', () => {
  let component: PlanPrice;
  let fixture: ComponentFixture<PlanPrice>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlanPrice]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanPrice);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
