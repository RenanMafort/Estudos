import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipesOperatorComponent } from './pipes-operator.component';

describe('PipesOperatorComponent', () => {
  let component: PipesOperatorComponent;
  let fixture: ComponentFixture<PipesOperatorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PipesOperatorComponent]
    });
    fixture = TestBed.createComponent(PipesOperatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
