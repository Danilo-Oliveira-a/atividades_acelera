import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AnimalModel } from '../model/animal-model';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  constructor(private http: HttpClient) { }

  getListar() {
    return this.http.get<AnimalModel[]>(environment.apiListarAnimal);
  }
  adicionar(animal: AnimalModel) {
    return this.http.post<AnimalModel>(environment.apiAdicionarAnimal, animal);
  }
  editar(animal: AnimalModel) {
    return this.http.put(environment.apiEditarAnimal, animal)
  }
  deletar(id: number) {
    return this.http.delete(environment.apiDeletarAnimal + id)
  }
}
