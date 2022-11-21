// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiAdicionarCuidador: 'http://localhost:8082/cuidador/salvar/',
  apiListarCuidador: 'http://localhost:8082/cuidador/listar',
  apiEditarCuidador: 'http://localhost:8082/cuidador/editar',
  apiDeletarCuidador: 'http://localhost:8082/cuidador/deletar/',
  apiMatricula: 'http://localhost:8082/cuidador/matricula',

  apiAdicionarJaula: 'http://localhost:8082/jaula/salvar/',
  apiListarJaula: 'http://localhost:8082/jaula/listar',
  apiEditarJaula: 'http://localhost:8082/jaula/editar',
  apiDeletarJaula: 'http://localhost:8082/jaula/deletar/',
  apiDeletarCuidadorJaula: 'http://localhost:8082/jaula/',

  apiAdicionarAnimal: 'http://localhost:8082/animal/salvar/',
  apiListarAnimal: 'http://localhost:8082/animal/listar',
  apiEditarAnimal: 'http://localhost:8082/animal/editar',
  apiDeletarAnimal: 'http://localhost:8082/animal/deletar/',

};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
