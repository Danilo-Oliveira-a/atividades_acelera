import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CuidadorModel } from 'src/app/cuidador/model/cuidador-model';
import { environment } from 'src/environments/environment';
import { JaulaModel } from '../model/jaula-model';


@Injectable({
  providedIn: 'root'
})
export class JaulaService {

  constructor(private http: HttpClient) { }

  getListar() {
    return this.http.get<JaulaModel[]>(environment.apiListarJaula);
  }
  getMatricula() {
    return this.http.get<string>(environment.apiMatricula);
  }
  adicionar(Jaula: JaulaModel) {
    console.log('service');
    console.log(Jaula);
    return this.http.post<JaulaModel[]>(environment.apiAdicionarJaula, Jaula);
  }
  editar(Jaula: JaulaModel) {
    return this.http.put(environment.apiEditarJaula, Jaula)
  }
  deletar(id: number) {
    return this.http.delete(environment.apiDeletarJaula + id)
  }
  deletarCuidadorDaJaula(idJaula: number, idCuidador: number) {
    return this.http.delete(environment.apiDeletarCuidadorJaula + idJaula + '/cuidador/' + idCuidador)
  }
}
