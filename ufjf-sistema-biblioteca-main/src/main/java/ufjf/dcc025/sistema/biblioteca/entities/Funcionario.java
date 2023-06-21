// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends Usuario {
    
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    
    @OneToMany(mappedBy = "funcionario")
    private Set<Emprestimo> emprestimosCadastrados = new HashSet<>();
    
    public Funcionario() {
        super();
    }

    public Funcionario(Integer matricula, String nome, String cpf, Date dataNascimento, String senha, Date dataAdmissao) {
        super(matricula, nome, cpf, dataNascimento, senha);
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Set<Emprestimo> getEmprestimosCadastrados() {
        return emprestimosCadastrados;
    }
}
