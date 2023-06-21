/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.sistema.biblioteca.repositories;

import ufjf.dcc025.sistema.biblioteca.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ufjf.dcc025.sistema.biblioteca.entities.Aluno;

/**
 *
 * @author arauj
 */
public class AlunoRepository {
    
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public AlunoRepository() {
    }    
    
    public List<Aluno> findAll() {
        List<Aluno> alunos = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            alunos = session.createQuery("from Aluno").getResultList();
            transaction.commit();
        } catch (Exception e) {
            alunos = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return alunos;
    }
    
    public Aluno findOne(int matricula) {
        Aluno aluno = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            aluno = (Aluno) session.createQuery("from Aluno where matricula = :matricula")
                    .setParameter("matricula", matricula)
                    .getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            aluno = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return aluno;
    }
    
    public boolean create(Aluno aluno) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(aluno);
            transaction.commit();
        } catch (Exception e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
    
    public boolean update(Aluno aluno) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(aluno);
            transaction.commit();
        } catch (Exception e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
}
