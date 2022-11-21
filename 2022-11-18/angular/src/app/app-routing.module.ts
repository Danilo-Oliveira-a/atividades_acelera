import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdicionarAnimalComponent } from './animal/adicionar/adicionar-animal/adicionar-animal.component';
import { AnimalComponent } from './animal/animal/animal.component';
import { CuidadorComponent } from './cuidador/cuidador.component';
import { HomeComponent } from './home/home/home.component';
import { JaulaComponent } from './jaula/jaula.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'cuidador', component: CuidadorComponent },
  { path: 'jaula', component: JaulaComponent },
  { path: 'animal', component: AnimalComponent },
  { path: 'adicionarAnimal', component: AdicionarAnimalComponent },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
