import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { JaulaService } from 'src/app/jaula/service/jaula.service';
import { CuidadorModel } from '../../model/cuidador-model';
import { CuidadorService } from '../../service/cuidador.service';

@Component({
  selector: 'app-adicionar-cuidador-dialog',
  templateUrl: './adicionar-cuidador-dialog.component.html',
  styleUrls: ['./adicionar-cuidador-dialog.component.css']
})
export class AdicionarCuidadorDialogComponent implements OnInit {

  constructor(
    public dialogEditar: MatDialogRef<AdicionarCuidadorDialogComponent>,
    private service: CuidadorService) {
  }
  matricula: string = '';
  cuidador: CuidadorModel = { id: 0, matricula: this.matricula, nome: '' };

  ngOnInit(): void {
    this.service.getMatricula().subscribe(
      {
        next: res => {
          this.matricula = res;
          this.cuidador = { id: 0, matricula: this.matricula, nome: '' };
          console.log(this.cuidador);
        },
        error: err => {
          console.log('err');
          console.log(err.error.text);
          this.matricula = err.error.text;
          this.cuidador = { id: 0, matricula: this.matricula, nome: '' };
          console.log(this.cuidador);
        }
      });

  }
  onNoClick(): void {
    this.dialogEditar.close();
  }
  adicionrCuidador() {
    console.log(this.cuidador);
    this.service.adicionar(this.cuidador).subscribe({
      next: data => {
        console.log('SUCESSO: ' + data);
        this.dialogEditar.close("OK");
      },
      error: error => {
        this.dialogEditar.close();
        console.error('There was an error!', error);
      }
    });
  }
}