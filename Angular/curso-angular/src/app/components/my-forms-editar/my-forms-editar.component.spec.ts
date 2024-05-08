import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyFormsEDITARComponent } from './my-forms-editar.component';

describe('MyFormsEDITARComponent', () => {
  let component: MyFormsEDITARComponent;
  let fixture: ComponentFixture<MyFormsEDITARComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyFormsEDITARComponent]
    });
    fixture = TestBed.createComponent(MyFormsEDITARComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
