import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarCuidadorDialogComponent } from './editar-cuidador-dialog.component';

describe('EditarCuidadorDialogComponent', () => {
  let component: EditarCuidadorDialogComponent;
  let fixture: ComponentFixture<EditarCuidadorDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarCuidadorDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarCuidadorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
