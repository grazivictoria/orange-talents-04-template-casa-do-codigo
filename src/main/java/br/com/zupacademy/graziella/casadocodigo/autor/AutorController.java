package br.com.zupacademy.graziella.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.graziella.casadocodigo.util.validacoes.EmailDuplicadoValidator;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private EmailDuplicadoValidator emailDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailDuplicadoValidator);
	}
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> salvarAutor(@RequestBody @Valid NovoAutorRequest request) {
		
		Autor novoAutor = request.converter();
		autorRepository.save(novoAutor);
		
		return ResponseEntity.ok().build();
	}
}
