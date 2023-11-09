package gerenciamento.livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gerenciamento.livros.entities.livros;
import gerenciamento.livros.servicies.livrosservice;

@RestController
@RequestMapping("/livros")
public class livroscontrollers {

	private final livrosservice livrosservice;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	@Autowired
	public livroscontrollers(livrosservice livrosservice) {
		this.livrosservice = livrosservice;
	}

	@PostMapping
	public livros createLivros(@RequestBody livros livros) {
		return livrosservice.savelivros(livros);
	}

	@GetMapping("/{id}")
	public ResponseEntity<livros> getLivros(@PathVariable Long id) {
		livros livros = livrosservice.getlivrosById(id);
		if (livros != null) {
			return ResponseEntity.ok(livros);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void deleteLivros(@PathVariable Long id) {
		livrosservice.deletelivro(id);
	}

	@GetMapping
	public ResponseEntity<List<livros>> getAllLivros(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<livros> livros = livrosservice.getAlllivros();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(livros);
	}

	@PutMapping("/{id}")
	public livros updateLivros(@PathVariable Long id, @RequestBody livros livros) {
		return livrosservice.updatelivros(id, livros);
	}

}