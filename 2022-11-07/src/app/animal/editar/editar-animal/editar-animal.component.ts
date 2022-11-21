import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { CuidadorModel } from 'src/app/cuidador/model/cuidador-model';
import { JaulaModel } from 'src/app/jaula/model/jaula-model';
import { JaulaService } from 'src/app/jaula/service/jaula.service';
import { AnimalModel } from '../../model/animal-model';
import { AnimalService } from '../../service/animal.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editar-animal',
  templateUrl: './editar-animal.component.html',
  styleUrls: ['./editar-animal.component.css']
})
export class EditarAnimalComponent implements OnInit {

  animal: AnimalModel;
  constructor(private service: AnimalService, private serviceJaula: JaulaService, private router: Router) {
    const navigation = this.router.getCurrentNavigation()!;
    const state = navigation.extras.state as { example: AnimalModel };
    this.animal = state.example;
    console.log('nivgator with data');
    console.log(this.animal);
  }




  toppings = new FormControl('');
  private subscription: Subscription = new Subscription();
  jaulas: Array<JaulaModel> = [];
  cuidadorres: Array<CuidadorModel> = [];
  public jaula: JaulaModel = {
    id: 0,
    numeroJaula: '',
    nomeZoologico: '',
    bloco: '',
    cuidadores: this.cuidadorres
  };

  nome = new FormControl('', [Validators.required]);
  especie = new FormControl('', [Validators.required]);
  raca = new FormControl('', [Validators.required]);
  dataDeNascimento = new FormControl('', [Validators.required]);
  jaulaSelect = new FormControl('', [Validators.required]);

  ngOnInit(): void {

    this.getJaulas();
  }


  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
  public getJaulas() {
    console.log('listar jaulas');
    this.subscription = this.serviceJaula.getListar().subscribe(res => {
      this.jaulas = res;
    });
  }

  salvar() {
    console.log('adicionar animal');
    console.log(this.animal);
    this.subscription = this.service.editar(this.animal).subscribe(res => {
      console.log(res);
      if (res) {
        console.log('adicionado animal colocar a redirect rota aqui');
      }
    });
    this.router.navigate(['/animal']).then(() => {
      window.location.reload();
    });
  }

  getErrorMessage() {
    let msgError: any = '';
    if (this.nome.hasError('required')
      || this.especie.hasError('required')
      || this.raca.hasError('required')
      || this.dataDeNascimento.hasError('required')
      || this.jaulaSelect.hasError('required')
    ) {
      msgError = 'Campo é obrigatório!';
    }
    return msgError;
  }

}




