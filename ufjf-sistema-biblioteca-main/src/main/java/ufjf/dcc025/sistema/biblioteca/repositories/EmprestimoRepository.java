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
import ufjf.dcc025.sistema.biblioteca.entities.Emprestimo;

/**
 *
 * @author arauj
 */
public class EmprestimoRepository {
    
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public EmprestimoRepository() {
    }
    
    public List<Emprestimo> findAll() {
        List<Emprestimo> emprestimos = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            emprestimos = session.createQuery("from Emprestimo").getResultList();
            transaction.commit();
        } catch (Exception e) {
            emprestimos = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return emprestimos;
    }
    
    public Emprestimo findOne(int id) {
        Emprestimo emprestimo = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            emprestimo = (Emprestimo) session.createQuery("from Emprestimo where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            emprestimo = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return emprestimo;
    }
    
    public boolean create(Emprestimo emprestimo) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(emprestimo);
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
    
    public boolean update(Emprestimo emprestimo) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(emprestimo);
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
