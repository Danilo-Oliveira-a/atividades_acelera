import { JaulaModel } from "src/app/jaula/model/jaula-model";

export interface AnimalModel {
    id: number;
    nome: string;
    especie: string;
    raca: string;
    dataDeNascimento: string;
    jaula: JaulaModel
}
