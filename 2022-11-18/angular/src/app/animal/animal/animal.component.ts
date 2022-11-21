import { Component, OnInit } from '@angular/core';

import { ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { AnimalModel } from '../model/animal-model';
import { AnimalService } from '../service/animal.service';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'especie', 'raca', 'dataDeNascimento', 'editar', 'deletar'];

  //jaula: JaulaModel
  dataSource = new MatTableDataSource<AnimalModel>;
  private subscription: Subscription = new Subscription();
  @ViewChild(MatPaginator) paginator: MatPaginator | null = null;
  constructor(private service: AnimalService) { }


  ngOnInit(): void {
    this.listar();

  }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  public listar() {
    console.log('listar animais');
    this.subscription = this.service.getListar().subscribe(response => {
      this.dataSource = new MatTableDataSource<AnimalModel>(response);
      console.log(this.dataSource);
      this.dataSource.paginator = this.paginator;
    });
  }

  excuir(id: number) {
    console.log('exlcuir animal');
    this.service.deletar(id).subscribe(res => {
      console.log(res);
    });
  }
  openEditDialog(data: AnimalModel) {

  }

}
