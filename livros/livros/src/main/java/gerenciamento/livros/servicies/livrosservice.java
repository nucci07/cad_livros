package gerenciamento.livros.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gerenciamento.livros.entities.livros;
import gerenciamento.livros.repositories.livrosrepository;

@Service
public class livrosservice {
	private livrosrepository livrosrepository;

	public livrosservice(livrosrepository livrosrepository) {
		this.livrosrepository = livrosrepository;
	}

	public livros savelivro(livros livros) {
		return livrosrepository.save(livros);
	}

	public livros getlivrosById(Long id) {
		return livrosrepository.findById(id).orElse(null);
	}

	public List<livros> getAlllivros() {
		return livrosrepository.findAll();
	}

	public void deletelivro(Long id) {
		livrosrepository.deleteById(id);
	}

	public livros savelivros(livros livros) {
		return livrosrepository.save(livros);
	}

	public livros updatelivros(Long id, livros novolivros) {
		Optional<livros> livrosOptional = livrosrepository.findById(id);

		if (livrosOptional.isPresent()) {
			livros livrosExistente = livrosOptional.get();
			livrosExistente.setDescricao(novolivros.getDescricao());
			livrosExistente.setIsbn(novolivros.getIsbn());
			return livrosrepository.save(livrosExistente);
		} else {
			return null;
		}
	}
}
