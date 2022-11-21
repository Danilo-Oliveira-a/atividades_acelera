import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarAnimalComponent } from './adicionar-animal.component';

describe('AdicionarAnimalComponent', () => {
  let component: AdicionarAnimalComponent;
  let fixture: ComponentFixture<AdicionarAnimalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdicionarAnimalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdicionarAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
