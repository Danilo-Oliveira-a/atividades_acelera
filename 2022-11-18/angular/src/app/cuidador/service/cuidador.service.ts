import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { CuidadorModel } from '../model/cuidador-model';

@Injectable({
  providedIn: 'root'
})
export class CuidadorService {

  constructor(private http: HttpClient) { }

  getListar() {
    return this.http.get<CuidadorModel[]>(environment.apiListarCuidador);
  }
  getMatricula() {
    return this.http.get<string>(environment.apiMatricula);
  }
  adicionar(cuidador: CuidadorModel) {
    return this.http.post<CuidadorModel[]>(environment.apiAdicionarCuidador, cuidador);
  }
  editar(cuidador: CuidadorModel) {
    return this.http.put(environment.apiEditarCuidador, cuidador)
  }
  deletar(id: number) {
    return this.http.delete(environment.apiDeletarCuidador + id)
  }


}
