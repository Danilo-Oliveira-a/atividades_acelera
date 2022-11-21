import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-deletar-cuidador-dialog',
  templateUrl: './deletar-cuidador-dialog.component.html',
  styleUrls: ['./deletar-cuidador-dialog.component.css']
})
export class DeletarCuidadorDialogComponent implements OnInit {

  constructor(public dialogDeletar: MatDialogRef<DeletarCuidadorDialogComponent>,) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogDeletar.close();
  }
  excluir(): void {
    this.dialogDeletar.close('EXLCUIR');
  }

}
