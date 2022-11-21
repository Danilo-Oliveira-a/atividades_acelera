import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarCuidadorDialogComponent } from './adicionar-cuidador-dialog.component';

describe('AdicionarCuidadorDialogComponent', () => {
  let component: AdicionarCuidadorDialogComponent;
  let fixture: ComponentFixture<AdicionarCuidadorDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdicionarCuidadorDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdicionarCuidadorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
