package br.atos.zoologico.controller;

import br.atos.zoologico.model.Animal;
import br.atos.zoologico.model.Jaula;
import br.atos.zoologico.repository.AnimalRepository;
import br.atos.zoologico.repository.CuidadorRepository;
import br.atos.zoologico.repository.JaulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value = "/animal")
@CrossOrigin
public class AnimalController {

	@Autowired
	JaulaRepository jaulaRepository;

	@Autowired
	CuidadorRepository cuidadorRepository;

	@Autowired
	AnimalRepository  animalRepository;

	@PostMapping(value = "/salvar")
	public ResponseEntity cadastroAnimal(@RequestBody  Animal animal) {
		try {
			return new ResponseEntity(animalRepository.save(animal), HttpStatus.CREATED);
		}
		catch (Exception ex){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listar")
	public ResponseEntity listaAnimais() {
		try {
			return new ResponseEntity(animalRepository.findAll(), HttpStatus.OK);
		}
		catch (Exception ex){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}


	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity deletaAnimal(@PathVariable ("id") long idReq) {
		try {
			Animal animal = animalRepository.findById(idReq);
			animalRepository.delete(animal);
			return new ResponseEntity(null, HttpStatus.OK);
		}
		catch (Exception ex){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}


	@PutMapping(value = "/editar")
	public ResponseEntity atualiza(@RequestBody Animal animal) {
		try {
			return new ResponseEntity(animalRepository.save(animal), HttpStatus.OK);
		}
		catch (Exception ex){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}

}
