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
import ufjf.dcc025.sistema.biblioteca.entities.Exemplar;

/**
 *
 * @author arauj
 */
public class ExemplarRepository {
    
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ExemplarRepository() {
    }
    
    public List<Exemplar> findAll() {
        List<Exemplar> exemplares = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            exemplares = session.createQuery("from Exemplar").getResultList();
            transaction.commit();
        } catch (Exception e) {
            exemplares = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return exemplares;
    }
    
    public Exemplar findOne(int id) {
        Exemplar exemplar = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            exemplar = (Exemplar) session.createQuery("from Exemplar where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            exemplar = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return exemplar;
    }
    
    public boolean create(Exemplar exemplar) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(exemplar);
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
    
    public boolean update(Exemplar exemplar) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(exemplar);
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
