import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletarCuidadorDialogComponent } from './deletar-cuidador-dialog.component';

describe('DeletarCuidadorDialogComponent', () => {
  let component: DeletarCuidadorDialogComponent;
  let fixture: ComponentFixture<DeletarCuidadorDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletarCuidadorDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeletarCuidadorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
