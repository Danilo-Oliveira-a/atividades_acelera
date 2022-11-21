import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarJaulaDialogComponent } from './editar-jaula-dialog.component';

describe('EditarJaulaDialogComponent', () => {
  let component: EditarJaulaDialogComponent;
  let fixture: ComponentFixture<EditarJaulaDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarJaulaDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarJaulaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
