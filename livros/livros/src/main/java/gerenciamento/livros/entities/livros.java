package gerenciamento.livros.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_livros")
public class livros {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String Descricao;

		private String isbn;

		public livros() {
		}

		public livros(Long id, String descricao, String isbn) {
			super();
			this.id = id;
			Descricao = descricao;
			this.isbn = isbn;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return Descricao;
		}

		public void setDescricao(String descricao) {
			Descricao = descricao;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		

		
}
