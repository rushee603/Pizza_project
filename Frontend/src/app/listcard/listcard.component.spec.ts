import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListcardComponent } from './listcard.component';

describe('ListcardComponent', () => {
  let component: ListcardComponent;
  let fixture: ComponentFixture<ListcardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListcardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
