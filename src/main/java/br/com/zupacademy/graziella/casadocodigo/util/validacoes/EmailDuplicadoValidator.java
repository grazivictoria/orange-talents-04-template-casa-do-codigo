package br.com.zupacademy.graziella.casadocodigo.util.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.graziella.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.graziella.casadocodigo.autor.NovoAutorRequest;

@Component
public class EmailDuplicadoValidator implements Validator{

	@Autowired
	private AutorRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		NovoAutorRequest request = (NovoAutorRequest) target;
		
		if(repository.existsByEmail(request.getEmail())) {
			errors.rejectValue("email", null, "Este email já está cadastrado");
		}
	}

}
