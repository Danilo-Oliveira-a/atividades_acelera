import { Component, OnInit, ViewChild } from '@angular/core';
import { Inject } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { CuidadorModel } from 'src/app/cuidador/model/cuidador-model';
import { CuidadorService } from 'src/app/cuidador/service/cuidador.service';
import { JaulaModel } from '../../model/jaula-model';
import { JaulaService } from '../../service/jaula.service';
import { ConfirmarExcluirJaulaComponent } from './confirmarDialog/confirmar-excluir-jaula/confirmar-excluir-jaula.component';


@Component({
  selector: 'app-editar-jaula-dialog',
  templateUrl: './editar-jaula-dialog.component.html',
  styleUrls: ['./editar-jaula-dialog.component.css']
})
export class EditarJaulaDialogComponent implements OnInit {

  constructor(
    public dialogEditar: MatDialogRef<EditarJaulaDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: JaulaModel,
    private service: JaulaService, private serviceCuidador: CuidadorService,
    public confirmDialog: MatDialog) {

  }
  private isExcluiu: boolean = false;

  displayedColumns: string[] = ['id', 'matricula', 'nome', 'deletar'];
  dataSource = new MatTableDataSource<CuidadorModel>;
  @ViewChild(MatPaginator) paginator: MatPaginator | null = null;

  ngOnInit(): void {
    if (this.isExcluiu === false) {
      this.dataSource = new MatTableDataSource<CuidadorModel>(this.data.cuidadores);
      this.dataSource.paginator = this.paginator;
      console.log('this.dataSource');
      console.log(this.dataSource);
    }

  }

  onNoClick(): void {
    this.dialogEditar.close();
  }
  editar(data: JaulaModel) {
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


  excuirCuidador(jaulaId: number, cuidador: CuidadorModel): void {
    if (this.data.cuidadores.length === 1) {
      this.openConfirmDialog(jaulaId, cuidador);
    }
    else {
      this.excluiCuidadorDaJaula(jaulaId, cuidador);
    }
  }

  openConfirmDialog(jaulaId: number, cuidador: CuidadorModel): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '600px';
    const dialogRef = this.confirmDialog.open(ConfirmarExcluirJaulaComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.serviceCuidador.deletar(cuidador.id);
      }
    });
  }
  excluiCuidadorDaJaula(jaulaId: number, cuidador: CuidadorModel) {
    this.service.deletarCuidadorDaJaula(jaulaId, cuidador.id).subscribe(
      res => {
        console.log('removido cuidador da Jaula');
        console.log(res);
        this.serviceCuidador.getListar().subscribe(response => {
          this.isExcluiu = true;
          console.log('nova lista de cuidadores da jaula');
          console.log(response);
          this.dataSource = new MatTableDataSource<CuidadorModel>(response);
          this.dataSource.paginator = this.paginator;
        });
      })
  }
}

