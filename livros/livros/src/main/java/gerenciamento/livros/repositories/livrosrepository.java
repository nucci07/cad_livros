package gerenciamento.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciamento.livros.entities.livros;

public interface livrosrepository extends JpaRepository<livros, Long> {

	}


