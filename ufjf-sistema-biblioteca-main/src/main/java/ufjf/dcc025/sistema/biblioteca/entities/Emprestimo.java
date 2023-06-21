// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ufjf.dcc025.sistema.biblioteca.services.BibliotecaService;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    
    @Temporal(TemporalType.DATE)
    private Date dataParaDevolucao;
    
    @Temporal(TemporalType.DATE)
    private Date dataDeDevolucao;
    
    @ManyToOne
    @JoinColumn(name = "exemplar_id", nullable = false)
    private Exemplar exemplar;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    public Emprestimo() {
        
    }

    public Emprestimo(Exemplar exemplar, Funcionario funcionario, Aluno aluno) throws Exception {
        Calendar cal = Calendar.getInstance();
        
        this.dataEmprestimo = cal.getTime();
        
        int diasDevolucao;
        if (exemplar.getDisponivel()) {
            diasDevolucao = exemplar.getEhNaoCircula() ? 1 : 7;
        } else {
            throw new Exception("Exemplar já se encontra emprestado!!");
        }       
        
        cal.add(Calendar.DAY_OF_MONTH, diasDevolucao);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        this.dataParaDevolucao = cal.getTime();
        this.dataDeDevolucao = null;
        
        this.exemplar = exemplar;
        this.funcionario = funcionario;
        this.aluno = aluno;
        
        this.exemplar.setDisponivel(false);
    }

    public Integer getId() {
        return id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public Date getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setDataDeDevolucao() {
        this.dataDeDevolucao = new Date();
        exemplar.setDisponivel(true);
    }  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.dataEmprestimo);
        hash = 53 * hash + Objects.hashCode(this.dataParaDevolucao);
        hash = 53 * hash + Objects.hashCode(this.dataDeDevolucao);
        hash = 53 * hash + Objects.hashCode(this.exemplar);
        hash = 53 * hash + Objects.hashCode(this.funcionario);
        hash = 53 * hash + Objects.hashCode(this.aluno);
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
