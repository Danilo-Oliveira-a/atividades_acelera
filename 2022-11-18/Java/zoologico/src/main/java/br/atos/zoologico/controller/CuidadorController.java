package br.atos.zoologico.controller;

import br.atos.zoologico.model.Cuidador;
import br.atos.zoologico.repository.CuidadorRepository;
import br.atos.zoologico.repository.JaulaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController  // Indica que a classe é do tipo controlador
@RequestMapping(value = "/cuidador")
@CrossOrigin
public class CuidadorController {

	@Autowired
	CuidadorRepository cuidadorRepository;

	@Autowired
	JaulaRepository jaulaRepository;

	@GetMapping(value = "/listar")
	public ResponseEntity<List<Cuidador>> listarCuidadores() {
		try{
			List<Cuidador> cuidadores = (List<Cuidador>) cuidadorRepository.findAll();
			return new ResponseEntity(cuidadores,HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/salvar")
	public ResponseEntity salvarCuidador(@RequestBody Cuidador cuidador) {
//		if(cuidador!=null && cuidador.getMatricula()==null){
//			cuidador.setMatricula(obterMatricula());
//		}
		try{
			return new ResponseEntity(cuidadorRepository.save(cuidador), HttpStatus.CREATED);
		}
		catch (Exception e){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(value = "/editar")
	public ResponseEntity atualizaCuidador(@RequestBody Cuidador cuidador) {
		try{
			Optional<Cuidador> cuidadorBanco = cuidadorRepository.findById(cuidador.getId());
			cuidadorBanco.ifPresent(d->cuidador.setJaulas(d.getJaulas()));
			cuidadorRepository.save(cuidador);
			return new ResponseEntity(cuidadorRepository.save(cuidador), HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping(value = "/matricula")
	public ResponseEntity<String> obterMatricula(){
		try{
			Iterable<Cuidador> cuidadores= cuidadorRepository.findAll(); // Busca todos titulares no banco de dados
			final long[] numId = {1};
			if(cuidadores!=null) {
				cuidadores.forEach(c -> {
					if (c.getId() > numId[0])
						numId[0] = c.getId();
				});
			}
			numId[0]++;
			String proxMatricula = "ZOO"+numId[0];
			return new ResponseEntity(proxMatricula, HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity deletaCuidadorMetodo(@PathVariable ("id") long idReq) {
		try{
			Cuidador cuidador = cuidadorRepository.findById(idReq);
			//deleta todas jaulas associada ao cuidador
			if(cuidador!=null){
				if(cuidador.getJaulas()!=null && !cuidador.getJaulas().isEmpty()){
					cuidador.getJaulas().stream().forEach(f->{
						if(f.getCuidadores()!=null && !f.getCuidadores().isEmpty()){
							//edita todas as jaulas que tem esse cuidador e remove
							if(f.getCuidadores().size()>1){
								List<Cuidador>cuidadoresJaula = f.getCuidadores().stream()
										.filter(c->c.getId()!=cuidador.getId()).collect(Collectors.toList());

								f.setCuidadores(cuidadoresJaula);
								//edita todas jaulas revomendo o cuidado que será excuido.
								jaulaRepository.save(f);
							}else{
								jaulaRepository.deleteAll(cuidador.getJaulas());
							}
						}
					});
				}
			}
			cuidadorRepository.delete(cuidador);
			return new ResponseEntity(null, HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
	}

}
