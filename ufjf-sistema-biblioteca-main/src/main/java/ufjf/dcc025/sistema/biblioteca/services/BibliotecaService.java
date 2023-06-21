// JOÃO PAULO DE CARVALHO ARAÚJO - 202065564C

package ufjf.dcc025.sistema.biblioteca.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ufjf.dcc025.sistema.biblioteca.entities.Funcionario;
import ufjf.dcc025.sistema.biblioteca.entities.Aluno;
import ufjf.dcc025.sistema.biblioteca.entities.Emprestimo;
import ufjf.dcc025.sistema.biblioteca.entities.Exemplar;
import ufjf.dcc025.sistema.biblioteca.entities.Livro;
import ufjf.dcc025.sistema.biblioteca.repositories.AlunoRepository;
import ufjf.dcc025.sistema.biblioteca.repositories.EmprestimoRepository;
import ufjf.dcc025.sistema.biblioteca.repositories.ExemplarRepository;
import ufjf.dcc025.sistema.biblioteca.repositories.FuncionarioRepository;
import ufjf.dcc025.sistema.biblioteca.repositories.LivroRepository;

public class BibliotecaService {
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private static Aluno alunoLogado;
    private static Funcionario funcLogado;
    
    private static AlunoRepository alunoRepository = new AlunoRepository();
    private static EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
    private static ExemplarRepository exemplarRepository = new ExemplarRepository();
    private static FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
    private static LivroRepository livroRepository = new LivroRepository();

    public static void startUp() {
        if (funcionarioRepository.findAll().isEmpty())
            seedFuncionarios();
    }
    
    private static void seedFuncionarios() {
        Date dataExemplo = null;
        try {
            dataExemplo = sdf.parse("01/01/2000");
        } catch (ParseException e1) {
            dataExemplo = null;
        } finally {
            Funcionario admin = new Funcionario(
                0, "admin", "00000000000", dataExemplo, "admin", dataExemplo);
        
            funcionarioRepository.create(admin);
        }        
    }

    public static Aluno getAlunoLogado() {
        return alunoLogado;
    }

    public static void setAlunoLogado(Aluno alunoLogado) {
        BibliotecaService.alunoLogado = alunoLogado;
    }

    public static Funcionario getFuncLogado() {
        return funcLogado;
    }

    public static void setFuncLogado(Funcionario funcLogado) {
        BibliotecaService.funcLogado = funcLogado;
    }
    
    public static List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }
    
    public static List<Emprestimo> getEmprestimos() {
        return emprestimoRepository.findAll();
    }
    
    public static List<Exemplar> getExemplares() {
        return exemplarRepository.findAll();
    }
    
    public static List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }
    
    public static List<Livro> getLivros() {
        return livroRepository.findAll();
    }
    
    public static Aluno getAluno(int id) {
        return alunoRepository.findOne(id);
    }
    
    public static Emprestimo getEmprestimo(int id) {
        return emprestimoRepository.findOne(id);
    }
    
    public static Exemplar getExemplar(int id) {
        return exemplarRepository.findOne(id);
    }
    
    public static Funcionario getFuncionario(int id) {
        return funcionarioRepository.findOne(id);
    }
    
    public static Livro getLivro(int id) {
        return livroRepository.findOne(id);
    }
    
    public static boolean createAluno(Aluno aluno) {
        return alunoRepository.create(aluno);
    }
    
    public static boolean createEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.create(emprestimo);
    }
    
    public static boolean createExemplar(Exemplar exemplar) {
        return exemplarRepository.create(exemplar);
    }
    
    public static boolean createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.create(funcionario);
    }
    
    public static boolean createLivro(Livro livro) {
        return livroRepository.create(livro);
    }
    
    public static boolean updateAluno(Aluno aluno) {
        return alunoRepository.update(aluno);
    }
    
    public static boolean updateEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.update(emprestimo);
    }
    
    public static boolean updateExemplar(Exemplar exemplar) {
        return exemplarRepository.update(exemplar);
    }
    
    public static boolean updateFuncionario(Funcionario funcionario) {
        return funcionarioRepository.update(funcionario);
    }
    
    public static boolean updateLivro(Livro livro) {
        return livroRepository.update(livro);
    }
}
