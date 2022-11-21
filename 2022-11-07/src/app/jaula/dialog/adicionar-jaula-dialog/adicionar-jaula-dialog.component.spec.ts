import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarJaulaDialogComponent } from './adicionar-jaula-dialog.component';

describe('AdicionarJaulaDialogComponent', () => {
  let component: AdicionarJaulaDialogComponent;
  let fixture: ComponentFixture<AdicionarJaulaDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdicionarJaulaDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdicionarJaulaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
