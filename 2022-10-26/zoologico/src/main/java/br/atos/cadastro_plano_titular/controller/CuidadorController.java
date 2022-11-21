package br.atos.cadastro_plano_titular.controller;

import br.atos.cadastro_plano_titular.model.Cuidador;
import br.atos.cadastro_plano_titular.model.Jaula;
import br.atos.cadastro_plano_titular.repository.CuidadorRepository;
import br.atos.cadastro_plano_titular.repository.JaulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller // Indica que a classe é do tipo controlador
@RequestMapping(value = "/cuidador")
public class CuidadorController {

	@Autowired
	CuidadorRepository cuidadorRepository;

	@Autowired
	JaulaRepository jaulaRepository;

	@GetMapping(value = "/cadastrar")
	public ModelAndView cadastroCuidador() {
		//add lista de jaulas
		ModelAndView modelAndView = new ModelAndView("cuidadorCadastrarHtml");
		Iterable<Cuidador> cuidadores= cuidadorRepository.findAll();
		final long[] numId = {1};
		if(cuidadores!=null) {
			cuidadores.forEach(c -> {
				if (c.getId() > numId[0])
					numId[0] = c.getId();
			});
		}
		numId[0]++;
		String matricula = "ZOO"+numId[0];
		modelAndView.addObject("matricula", matricula);//
		return modelAndView;
	}
	
	@PostMapping(value = "/cadastrar")
	public String cadastroCuidador(Cuidador cuidador) {
		if(cuidador!=null && cuidador.getMatricula()==null){
			cuidador.setMatricula(obterMatricula());
		}
		cuidadorRepository.save(cuidador);
		return "redirect:/cuidador/listar";
	}
	private String obterMatricula(){
		Iterable<Cuidador> cuidadores= cuidadorRepository.findAll(); // Busca todos titulares no banco de dados
		final long[] numId = {1};
		if(cuidadores!=null) {
			cuidadores.forEach(c -> {
				if (c.getId() > numId[0])
					numId[0] = c.getId();
			});
		}
		numId[0]++;
		return  "ZOO"+numId[0];
	}
	@GetMapping("/listar")
	public ModelAndView listaCuidadores() {
		ModelAndView modelAndView = new ModelAndView("cuidadorListarHtml"); // Objeto que recebe o "endereço de uma pagina HTML" e um ou mais objetos que também podem ser uma lista.
		Iterable<Cuidador> cuidadores= cuidadorRepository.findAll(); // Busca todos titulares no banco de dados
		modelAndView.addObject("cuidadores", cuidadores);// Adiciona a lista de titulares no objeto "ModelAndView";


		String matricula = obterMatricula();
		modelAndView.addObject("matricula", matricula);//
		return modelAndView;
	}

	@GetMapping(value = "/deletar/{id}")
	public String deletaCuidadorMetodo(@PathVariable ("id") long idReq) {
		Cuidador cuidador = cuidadorRepository.findById(idReq);
		//deleta todas jaulas associada ao cuidador
		if(cuidador!=null){
			if(cuidador.getJaulas()!=null && !cuidador.getJaulas().isEmpty()){
				jaulaRepository.deleteAll(cuidador.getJaulas());
			}
		}
		cuidadorRepository.delete(cuidador);
		return "redirect:/cuidador/listar";
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView editaCuidadorMetodo(@PathVariable("id") long idReq) {
		Cuidador cuidador = cuidadorRepository.findById(idReq);
		ModelAndView modelAndView = new ModelAndView("cuidadorEditarHtml");
		modelAndView.addObject("cuidador", cuidador);

		//modelAndView.addObject("cuidadores", jaula.getCuidadores());

		return modelAndView;
	}

	@PostMapping(value = "/editar")
	public String atualizaCuidador(Cuidador cuidador) {
		Optional<Cuidador> cuidadorBanco = cuidadorRepository.findById(cuidador.getId());
		cuidadorBanco.ifPresent(d->d.setJaulas(cuidador.getJaulas()));
		cuidadorRepository.save(cuidador);
		return "redirect:/cuidador/listar";
	}
}
