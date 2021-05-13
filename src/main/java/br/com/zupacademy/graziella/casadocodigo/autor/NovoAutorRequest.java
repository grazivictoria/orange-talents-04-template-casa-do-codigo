package br.com.zupacademy.graziella.casadocodigo.autor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class NovoAutorRequest {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @Email
	private String email;
	@Column(columnDefinition = "text") @Size(max = 400)
	@NotNull @NotEmpty
	private String descricao;
	
	public Autor converter() {
		return new Autor(nome, email, descricao);
	}

	public NovoAutorRequest(@NotEmpty String nome, @NotEmpty @Email String email,
			@Size(max = 400) @NotEmpty String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
}
