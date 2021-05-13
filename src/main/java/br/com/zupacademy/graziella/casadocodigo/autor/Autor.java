package br.com.zupacademy.graziella.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Autor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @Email
	private String email;
	@Column(columnDefinition = "text") @Size(max = 400)
	@NotNull @NotEmpty
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Autor(@NotEmpty String nome, @NotEmpty @Email String email,
			@Size(max = 400) @NotEmpty String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
}
