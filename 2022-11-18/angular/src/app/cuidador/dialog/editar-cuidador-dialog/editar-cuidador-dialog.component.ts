import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { CuidadorModel } from '../../model/cuidador-model';
import { CuidadorService } from '../../service/cuidador.service';

@Component({
  selector: 'app-editar-cuidador-dialog',
  templateUrl: './editar-cuidador-dialog.component.html',
  styleUrls: ['./editar-cuidador-dialog.component.css']
})
export class EditarCuidadorDialogComponent implements OnInit {

  constructor(
    public dialogEditar: MatDialogRef<EditarCuidadorDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CuidadorModel,
    private service: CuidadorService) {

  }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogEditar.close();
  }
  editarCuidador(data: CuidadorModel) {
    this.service.editar(data).subscribe({
      next: data => {
        console.log(data);
        this.dialogEditar.close("OK");
      },
      error: error => {
        this.dialogEditar.close();
      }
    });

  }
}
