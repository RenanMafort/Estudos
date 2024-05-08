import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyFormsComponent } from './my-forms.component';

describe('MyFormsComponent', () => {
  let component: MyFormsComponent;
  let fixture: ComponentFixture<MyFormsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyFormsComponent]
    });
    fixture = TestBed.createComponent(MyFormsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
