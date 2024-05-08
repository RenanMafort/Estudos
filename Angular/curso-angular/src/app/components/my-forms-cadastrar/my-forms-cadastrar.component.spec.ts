import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyFormsCadastrarComponent } from './my-forms-cadastrar.component';

describe('MyFormsCadastrarComponent', () => {
  let component: MyFormsCadastrarComponent;
  let fixture: ComponentFixture<MyFormsCadastrarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyFormsCadastrarComponent]
    });
    fixture = TestBed.createComponent(MyFormsCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
