package br.atos.cadastro_plano_titular.controller;

import br.atos.cadastro_plano_titular.model.Pessoa;
import br.atos.cadastro_plano_titular.model.Pet;
import br.atos.cadastro_plano_titular.repository.PessoaRepository;
import br.atos.cadastro_plano_titular.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller // Indica que a classe é do tipo controlador
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	@Autowired
	PetsRepository petsRepository;

	@GetMapping(value = "/cadastrar")
	public String cadastroPessoa() {
		return"pessoaCadastrarHtml";
	}
	
	@PostMapping(value = "/cadastrar")
	public String cadastroPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return "redirect:/pessoa/listar";
	}

	@GetMapping("/listar")
	public ModelAndView listaPessoas() {
		ModelAndView pessoaModelAndView = new ModelAndView("pessoaListarHtml"); // Objeto que recebe o "endereço de uma pagina HTML" e um ou mais objetos que também podem ser uma lista.
		Iterable<Pessoa> pessoas= pessoaRepository.findAll(); // Busca todos titulares no banco de dados
		pessoaModelAndView.addObject("pessoas", pessoas);// Adiciona a lista de titulares no objeto "ModelAndView";
		return pessoaModelAndView;
	}

	@GetMapping(value = "/deletar/{id}")
	public String deletaPessoaMetodo(@PathVariable ("id") long idReq) {
		Pessoa pessoa = pessoaRepository.findById(idReq);
		pessoaRepository.delete(pessoa);
		return "redirect:/pessoa/listar";
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView editaPessoaMetodo(@PathVariable ("id") long idReq) {
		Pessoa pessoa = pessoaRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("pessoaEditarHtml");
		modelAndView.addObject("pessoa", pessoa);

		Iterable<Pet> pets = petsRepository.findByPessoa(pessoa);
		modelAndView.addObject("pets", pets);

		return modelAndView;
	}


	@PostMapping(value = "/editar")
	public String atualizaPessoa(Pessoa pessoa) {
		long id = pessoa.getId();
		pessoaRepository.save(pessoa);
		return "redirect:/pessoa/listar";
	}

	@GetMapping(value = "/pet/cadastrar/{id}")
	public ModelAndView adicionaPetMetodo(@PathVariable("id") long idReq) {
		Pessoa pessoa = pessoaRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("petCadastrarHtml");
		modelAndView.addObject("pessoa", pessoa);
		Iterable<Pet> pets = petsRepository.findByPessoa(pessoa);
		modelAndView.addObject("pets", pets);
		return modelAndView;
	}

	@PostMapping(value = "/pet/cadastrar/{id}")
	public String adicionaPet(@PathVariable("id") long idReq, Pet pet) {
		Pessoa pessoa = pessoaRepository.findById(idReq);
		pet.setPessoa(pessoa);
		petsRepository.save(pet);
		return "redirect:/pessoa/pet/cadastrar/{id}";
	}

	@GetMapping(value = "/pet/deletar/{id}")
	public String deletaPessoaPetMetodo(@PathVariable ("id") long idReq) {
		Pet pet = petsRepository.findById(idReq);
		petsRepository.delete(pet);
		return "redirect:/pessoa/editar/"+pet.getPessoa().getId();
	}

	@GetMapping(value = "/pet/editar/{id}")
	public ModelAndView editaPessoaPetMetodo(@PathVariable ("id") long idReq) {
		Pet pet = petsRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("petEditarHtml");
		modelAndView.addObject("pet", pet);

		return modelAndView;
	}
	@PostMapping(value = "/pet/editar")
	public String editaPet(Pet pet) {
		Pet petBanco = petsRepository.findById(pet.getId());
		pet.setPessoa(petBanco.getPessoa());
		petsRepository.save(pet);
		return "redirect:/pessoa/editar/"+pet.getPessoa().getId();
	}

}
