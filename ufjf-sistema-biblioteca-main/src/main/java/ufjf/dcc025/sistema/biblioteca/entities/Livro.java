// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Livro")
public class Livro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private String editora;
    private String ano;
    private String edicao;
    private Integer numPaginas;
    private String isbn;
    private String idioma;
    
    @OneToMany(mappedBy = "livro")
    private Set<Exemplar> exemplares = new HashSet<>();
    
    public Livro() {
        
    }

    public Livro(String titulo, String autor, String editora, String ano, String edicao, Integer numPaginas, String isbn, String idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.edicao = edicao;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.idioma = idioma;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }
    
    public int getQuantDispNaoCircula() {
        return (int) this.exemplares.stream()
                .filter(x -> x.getEhNaoCircula() && x.getDisponivel())
                .count();
    }
    
    public int getQuantDispEmprestimo() {
        return (int) this.exemplares.stream()
                .filter(x -> !x.getEhNaoCircula() && x.getDisponivel())
                .count();
    }

    public Set<Exemplar> getExemplares() {
        return exemplares;
    }  

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.titulo);
        hash = 71 * hash + Objects.hashCode(this.autor);
        hash = 71 * hash + Objects.hashCode(this.editora);
        hash = 71 * hash + Objects.hashCode(this.ano);
        hash = 71 * hash + Objects.hashCode(this.edicao);
        hash = 71 * hash + Objects.hashCode(this.numPaginas);
        hash = 71 * hash + Objects.hashCode(this.isbn);
        hash = 71 * hash + Objects.hashCode(this.idioma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
}
