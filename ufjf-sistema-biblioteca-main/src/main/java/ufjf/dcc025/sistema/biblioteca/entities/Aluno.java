/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.sistema.biblioteca.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author arauj
 */
@Entity
@Table(name = "Aluno")
public class Aluno extends Usuario {
    
    @OneToMany(mappedBy = "aluno")
    private Set<Emprestimo> emprestimos = new HashSet<>();

    public Aluno() {
        super();
    }

    public Aluno(Integer matricula, String nome, String cpf, Date dataNascimento, String senha) {
        super(matricula, nome, cpf, dataNascimento, senha);
    }

    public Set<Emprestimo> getEmprestimos() {
        return emprestimos;
    }   
    
}
