package br.atos.zoologico.controller;

import br.atos.zoologico.model.Animal;
import br.atos.zoologico.model.Jaula;
import br.atos.zoologico.repository.AnimalRepository;
import br.atos.zoologico.repository.CuidadorRepository;
import br.atos.zoologico.repository.JaulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller // Indica que a classe é do tipo controlador
@RequestMapping(value = "/animal")
public class AnimalController {

	@Autowired
	JaulaRepository jaulaRepository;

	@Autowired
	CuidadorRepository cuidadorRepository;

	@Autowired
	AnimalRepository  animalRepository;

	@GetMapping(value = "/cadastrar")
	public ModelAndView cadastroAnimal() {
		//add lista de cuidadores
		ModelAndView modelAndView = new ModelAndView("animalCadastrarHtml");
		Iterable<Jaula> jaulas = jaulaRepository.findAll();
		modelAndView.addObject("jaulas", jaulas);
		return modelAndView;
	}
	
	@PostMapping(value = "/cadastrar")
	public String cadastroAnimal(Animal animal) {
		animalRepository.save(animal);
		return "redirect:/animal/listar";
	}

	@GetMapping("/listar")
	public ModelAndView listaAnimais() {
		ModelAndView modelAndView = new ModelAndView("animalListarHtml"); // Objeto que recebe o "endereço de uma pagina HTML" e um ou mais objetos que também podem ser uma lista.
		Iterable<Animal> animais=animalRepository.findAll();
		modelAndView.addObject("animais", animais);//
		Iterable<Jaula> jaulas= jaulaRepository.findAll(); // Busca todos titulares no banco de dados
		modelAndView.addObject("jaulas", jaulas);// Adiciona a lista de titulares no objeto "ModelAndView";
		return modelAndView;
	}


	@GetMapping(value = "/deletar/{id}")
	public String deletaAnimalMetodo(@PathVariable ("id") long idReq) {
		Animal animal = animalRepository.findById(idReq);
		animalRepository.delete(animal);
		return "redirect:/animal/listar";
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView editaAnimalMetodo(@PathVariable("id") long idReq) {
		Animal animal = animalRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("animalEditarHtml");
		modelAndView.addObject("animal", animal);

		modelAndView.addObject("jaula", animal.getJaula());

		return modelAndView;
	}


	@PostMapping(value = "/editar")
	public String atualiza(Jaula jaula) {
		Jaula jaulaBanco = jaulaRepository.findById(jaula.getId());
		jaula.setCuidadores(jaulaBanco.getCuidadores());
		jaulaRepository.save(jaula);
		return "redirect:/jaula/listar";
	}


	@GetMapping(value = "/jaula/deletar/{id}")
	public String deletaJaulaAnimalMetodo(@PathVariable ("id") long idReq) {
		//Cuidador cuidador = cuidadorRepository.findById(idReq);
//		cuidadorRepository.delete(cuidador);
		return "redirect:/animal/editar/";
	}

	@GetMapping(value = "/jaula/editar/{id}")
	public ModelAndView editaJaulaAnimalMetodo(@PathVariable ("id") long idReq) {
//		Pet pet = petsRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("animalEditarHtml");
//		modelAndView.addObject("pet", pet);

		return modelAndView;
	}
/*
	@GetMapping(value = "/deletar/{id}")
	public String deletaPessoaMetodo(@PathVariable ("id") long idReq) {
		Pessoa pessoa = pessoaRepository.findById(idReq);
		pessoaRepository.delete(pessoa);
		return "redirect:/pessoa/listar";
	}





	@PostMapping(value = "/pet/cadastrar/{id}")
	public String adicionaPet(@PathVariable("id") long idReq, Pet pet) {
		Pessoa pessoa = pessoaRepository.findById(idReq);
		pet.setPessoa(pessoa);
		petsRepository.save(pet);
		return "redirect:/pessoa/pet/cadastrar/{id}";
	}


	@PostMapping(value = "/pet/editar")
	public String editaPet(Pet pet) {
		Pet petBanco = petsRepository.findById(pet.getId());
		pet.setPessoa(petBanco.getPessoa());
		petsRepository.save(pet);
		return "redirect:/pessoa/editar/"+pet.getPessoa().getId();
	}
*/

}
