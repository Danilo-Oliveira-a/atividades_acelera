package br.atos.zoologico.controller;

import br.atos.zoologico.model.Cuidador;
import br.atos.zoologico.model.Jaula;
import br.atos.zoologico.repository.CuidadorRepository;
import br.atos.zoologico.repository.JaulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController // Indica que a classe é do tipo controlador
@RequestMapping(value = "/jaula")
@CrossOrigin
public class JaulaController {

	@Autowired
	JaulaRepository jaulaRepository;

	@Autowired
	CuidadorRepository cuidadorRepository;


	@GetMapping("/listar")
	public List<Jaula> listaJaulas() {
		return (List<Jaula>) jaulaRepository.findAll();
	}

	@PostMapping(value = "/salvar")
	public void cadastrarJaula(@RequestBody Jaula jaula) {
		jaulaRepository.save(jaula);
	}

	@PutMapping(value = "/editar")
	public void editarJaula(@RequestBody Jaula jaula) {
		Jaula jaulaBanco = jaulaRepository.findById(jaula.getId());
		jaula.setCuidadores(jaulaBanco.getCuidadores());
		jaulaRepository.save(jaula);
	}

	@DeleteMapping(value = "/deletar/{id}")
	public void deletarJaula(@PathVariable ("id") long idReq) {
		Jaula jaula = jaulaRepository.findById(idReq);
		jaulaRepository.delete(jaula);
	}

	@DeleteMapping(value = "/{idJaula}/cuidador/{idCuidador}")
	public void deletarCuidadorJaula(@PathVariable ("idJaula") long idJaula, @PathVariable ("idCuidador") long idCuidador) {
		Jaula jaula = jaulaRepository.findById(idJaula);
		if(jaula!=null){
			if(jaula.getCuidadores()!=null && !jaula.getCuidadores().isEmpty()){
				List<Cuidador> cuidadores = jaula.getCuidadores().stream().filter(c->c.getId()!=idCuidador).collect(Collectors.toList());
				jaula.setCuidadores(cuidadores);
			}
		}
		jaulaRepository.save(jaula);
	}


}
