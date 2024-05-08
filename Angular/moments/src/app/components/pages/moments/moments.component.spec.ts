import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MomentsComponent } from './moments.component';

describe('MomentsComponent', () => {
  let component: MomentsComponent;
  let fixture: ComponentFixture<MomentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MomentsComponent]
    });
    fixture = TestBed.createComponent(MomentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
