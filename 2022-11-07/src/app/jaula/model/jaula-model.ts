import { CuidadorModel } from "src/app/cuidador/model/cuidador-model";

export interface JaulaModel {
    id: number;
    numeroJaula: string;
    nomeZoologico: string;
    bloco: string;
    cuidadores: Array<CuidadorModel>;
}
