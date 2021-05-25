package br.com.zupacademy.graziella.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	boolean existsByEmail(String email);

}
