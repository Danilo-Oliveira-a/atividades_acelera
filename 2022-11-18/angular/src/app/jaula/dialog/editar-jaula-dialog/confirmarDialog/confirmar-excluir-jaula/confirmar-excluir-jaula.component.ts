import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirmar-excluir-jaula',
  templateUrl: './confirmar-excluir-jaula.component.html',
  styleUrls: ['./confirmar-excluir-jaula.component.css']
})
export class ConfirmarExcluirJaulaComponent implements OnInit {

  constructor(public dialogEditar: MatDialogRef<ConfirmarExcluirJaulaComponent>,) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogEditar.close();
  }

  excluir() {
    this.dialogEditar.close("EXCLUIR");
  }
}
