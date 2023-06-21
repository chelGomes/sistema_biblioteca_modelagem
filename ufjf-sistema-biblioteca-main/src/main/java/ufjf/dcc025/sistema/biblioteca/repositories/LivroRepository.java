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
import ufjf.dcc025.sistema.biblioteca.entities.Livro;

/**
 *
 * @author arauj
 */
public class LivroRepository {
    
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public LivroRepository() {
    }
    
    public List<Livro> findAll() {
        List<Livro> livros = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            livros = session.createQuery("from Livro").getResultList();
            transaction.commit();
        } catch (Exception e) {
            livros = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return livros;
    }
    
    public Livro findOne(int id) {
        Livro livro = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            livro = (Livro) session.createQuery("from Livro where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            livro = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return livro;
    }
    
    public boolean create(Livro livro) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(livro);
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
    
    public boolean update(Livro livro) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(livro);
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
