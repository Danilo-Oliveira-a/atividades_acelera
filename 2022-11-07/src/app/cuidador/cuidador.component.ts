import { Component, OnInit } from '@angular/core';
import { CuidadorService } from './service/cuidador.service';

import { ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { CuidadorModel } from './model/cuidador-model';
import { Subscription } from 'rxjs';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { EditarCuidadorDialogComponent } from './dialog/editar-cuidador-dialog/editar-cuidador-dialog.component';
import { AdicionarCuidadorDialogComponent } from './dialog/adicionar-cuidador-dialog/adicionar-cuidador-dialog.component';
import { DeletarCuidadorDialogComponent } from './dialog/deletar-cuidador-dialog/deletar-cuidador-dialog.component';
import { JaulaService } from '../jaula/service/jaula.service';
import { JaulaModel } from '../jaula/model/jaula-model';

@Component({
  selector: 'app-cuidador',
  templateUrl: './cuidador.component.html',
  styleUrls: ['./cuidador.component.css']
})
export class CuidadorComponent implements OnInit {



  displayedColumns: string[] = ['id', 'matricula', 'nome', 'editar', 'deletar'];
  dataSource = new MatTableDataSource<CuidadorModel>;
  private subscription: Subscription = new Subscription();


  @ViewChild(MatPaginator) paginator: MatPaginator | null = null;


  constructor(private service: CuidadorService, private serviceJaula: JaulaService, public dialog: MatDialog) {

  }


  ngOnInit(): void {
    this.listar();
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }



  public listar() {
    this.subscription = this.service.getListar().subscribe(response => {
      this.dataSource = new MatTableDataSource<CuidadorModel>(response);
      console.log(this.dataSource);
      this.dataSource.paginator = this.paginator;
    });

  }

  openEditDialog(cuidador: CuidadorModel): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: cuidador.id,
      nome: cuidador.nome,
      matricula: cuidador.matricula
    };
    dialogConfig.width = '500PX';
    dialogConfig.height = '250';
    const dialogRef = this.dialog.open(EditarCuidadorDialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.listar();
      }
    });
  }

  openSaveDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.width = '500PX';
    dialogConfig.height = '250';
    const dialogRef = this.dialog.open(AdicionarCuidadorDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.listar();
      }
    });
  }
  openDeleteDialog(cuidadorId: number): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '600PX';
    const dialogRef = this.dialog.open(DeletarCuidadorDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log('excuir')
        console.log(cuidadorId)
        this.service.deletar(cuidadorId).subscribe(
          res => {
            this.listar();
          })
      }
    });
  }


  excuir(cuidadorId: number): void {
    this.openDeleteDialog(cuidadorId);
  }


  applyFilter(event: Event) {
    console.log(event);
    // this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
