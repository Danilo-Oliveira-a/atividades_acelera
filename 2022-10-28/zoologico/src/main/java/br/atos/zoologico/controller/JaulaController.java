package br.atos.zoologico.controller;

import br.atos.zoologico.model.Cuidador;
import br.atos.zoologico.model.Jaula;
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
@RequestMapping(value = "/jaula")
public class JaulaController {

	@Autowired
	JaulaRepository jaulaRepository;

	@Autowired
	CuidadorRepository cuidadorRepository;

	@GetMapping(value = "/cadastrar")
	public ModelAndView cadastroJaula() {
		//add lista de cuidadores
		ModelAndView modelAndView = new ModelAndView("jaulaCadastrarHtml");
		Iterable<Cuidador> cuidadores = cuidadorRepository.findAll();
		modelAndView.addObject("cuidadores", cuidadores);
		return modelAndView;
	}
	
	@PostMapping(value = "/cadastrar")
	public String cadastroJaula(Jaula jaula) {
		jaulaRepository.save(jaula);


		return "redirect:/jaula/listar";
	}

	@GetMapping("/listar")
	public ModelAndView listaJaulas() {
		ModelAndView modelAndView = new ModelAndView("jaulaListarHtml"); // Objeto que recebe o "endereço de uma pagina HTML" e um ou mais objetos que também podem ser uma lista.
		Iterable<Jaula> jaulas= jaulaRepository.findAll(); // Busca todos titulares no banco de dados
		modelAndView.addObject("jaulas", jaulas);// Adiciona a lista de titulares no objeto "ModelAndView";

		Iterable<Cuidador> cuidadores = cuidadorRepository.findAll();
		modelAndView.addObject("cuidadores", cuidadores);

		return modelAndView;
	}


	@GetMapping(value = "/deletar/{id}")
	public String deletaJaulaMetodo(@PathVariable ("id") long idReq) {
		Jaula pessoa = jaulaRepository.findById(idReq);
		jaulaRepository.delete(pessoa);
		return "redirect:/jaula/listar";
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView editaJaulaMetodo(@PathVariable("id") long idReq) {
		Jaula jaula = jaulaRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("jaulaEditarHtml");
		modelAndView.addObject("jaula", jaula);

		modelAndView.addObject("cuidadores", jaula.getCuidadores());

		return modelAndView;
	}


	@PostMapping(value = "/editar")
	public String atualizaJaula(Jaula jaula) {
		Jaula jaulaBanco = jaulaRepository.findById(jaula.getId());
		jaula.setCuidadores(jaulaBanco.getCuidadores());
		jaulaRepository.save(jaula);
		return "redirect:/jaula/listar";
	}


	@GetMapping(value = "/cuidador/deletar/{id}")
	public String deletaJaulaCuidadorMetodo(@PathVariable ("id") long idReq) {
		//Cuidador cuidador = cuidadorRepository.findById(idReq);
//		cuidadorRepository.delete(cuidador);
		return "redirect:/pessoa/editar/";
	}

	@GetMapping(value = "/pet/editar/{id}")
	public ModelAndView editaJaulaCuidadorMetodo(@PathVariable ("id") long idReq) {
//		Pet pet = petsRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("cuidadorEditarHtml");
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
