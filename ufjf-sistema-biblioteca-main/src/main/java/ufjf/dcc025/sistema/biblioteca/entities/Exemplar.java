package ufjf.dcc025.sistema.biblioteca.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Exemplar")
public class Exemplar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean ehNaoCircula;
    private boolean disponivel;
    
    @OneToMany(mappedBy = "exemplar")
    private Set<Emprestimo> emprestimos = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    public Exemplar() {
    }

    public Exemplar(boolean ehNaoCircula, Livro livro) {
        this.ehNaoCircula = ehNaoCircula;
        this.disponivel = true;
        this.livro = livro;
    }       
    
    public Integer getId() {
        return id;
    }

    public boolean getEhNaoCircula() {
        return ehNaoCircula;
    }

    public void setEhNaoCircula(boolean ehNaoCircula) {
        if (disponivel)
            this.ehNaoCircula = ehNaoCircula;
    }  

    public boolean getDisponivel() {
        return disponivel;
    }

    public Set<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }  

    public Livro getLivro() {
        return livro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + (this.ehNaoCircula ? 1 : 0);
        hash = 41 * hash + (this.disponivel ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.livro);
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
        final Exemplar other = (Exemplar) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
}