import { Component, OnInit } from '@angular/core';

import { ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

import { JaulaService } from './service/jaula.service';

import { JaulaModel } from './model/jaula-model';
import { EditarJaulaDialogComponent } from './dialog/editar-jaula-dialog/editar-jaula-dialog.component';
import { AdicionarJaulaDialogComponent } from './dialog/adicionar-jaula-dialog/adicionar-jaula-dialog.component';

@Component({
  selector: 'app-jaula',
  templateUrl: './jaula.component.html',
  styleUrls: ['./jaula.component.css']
})
export class JaulaComponent implements OnInit {


  displayedColumns: string[] = ['id', 'numeroJaula', 'zoologico', 'bloco', 'editar', 'deletar'];
  dataSource = new MatTableDataSource<JaulaModel>;
  private subscription: Subscription = new Subscription();


  @ViewChild(MatPaginator) paginator: MatPaginator | null = null;


  constructor(private service: JaulaService, public dialog: MatDialog) {

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
      this.dataSource = new MatTableDataSource<JaulaModel>(response);
      console.log(this.dataSource);
      this.dataSource.paginator = this.paginator;
    });

  }

  openEditDialog(jaula: JaulaModel): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: jaula.id,
      numeroJaula: jaula.numeroJaula,
      nomeZoologico: jaula.nomeZoologico,
      bloco: jaula.bloco,
      cuidadores: jaula.cuidadores
    };
    dialogConfig.width = '600px';

    const dialogRef = this.dialog.open(EditarJaulaDialogComponent, dialogConfig);

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
    const dialogRef = this.dialog.open(AdicionarJaulaDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.listar();
      }
    });
  }

  excuir(id: number): void {
    console.log('excuir')
    console.log(id)
    this.service.deletar(id).subscribe(
      res => {
        this.listar();
      })

  }


  applyFilter(event: Event) {
    console.log(event);
    // this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
