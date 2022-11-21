import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

import { MatDialogRef } from '@angular/material/dialog';
import { CuidadorModel } from 'src/app/cuidador/model/cuidador-model';
import { CuidadorService } from 'src/app/cuidador/service/cuidador.service';
import { JaulaModel } from '../../model/jaula-model';
import { JaulaService } from '../../service/jaula.service';

@Component({
  selector: 'app-adicionar-jaula-dialog',
  templateUrl: './adicionar-jaula-dialog.component.html',
  styleUrls: ['./adicionar-jaula-dialog.component.css']
})
export class AdicionarJaulaDialogComponent implements OnInit {
  toppings = new FormControl('');
  cuidadores: Array<CuidadorModel> = [];
  jaula: JaulaModel = {
    id: 0,
    numeroJaula: '',
    nomeZoologico: '',
    bloco: '',
    cuidadores: this.cuidadores
  };


  constructor(
    private service: JaulaService,
    private serviceCuidador: CuidadorService,
    public dialogAdicionar: MatDialogRef<AdicionarJaulaDialogComponent>,) { }

  ngOnInit(): void {
    this.serviceCuidador.getListar().subscribe(res => {
      this.cuidadores = res;
    })
  }
  onNoClick(): void {
    this.dialogAdicionar.close();
  }
  salvar(data: JaulaModel) {
    console.log('salvar');
    console.log(data);
    this.service.adicionar(data).subscribe({
      next: data => {
        console.log(data);
        this.dialogAdicionar.close("OK");
      },
      error: error => {
        this.dialogAdicionar.close();
      }
    });
  }

}
