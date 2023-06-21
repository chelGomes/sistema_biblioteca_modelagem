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
import ufjf.dcc025.sistema.biblioteca.entities.Funcionario;

/**
 *
 * @author arauj
 */
public class FuncionarioRepository {
    
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public FuncionarioRepository() {
    }
    
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            funcionarios = session.createQuery("from Funcionario").getResultList();
            transaction.commit();
        } catch (Exception e) {
            funcionarios = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return funcionarios;
    }
    
    public Funcionario findOne(int id) {
        Funcionario funcionario = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            funcionario = (Funcionario) session.createQuery("from Funcionario where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            funcionario = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return funcionario;
    }
    
    public boolean create(Funcionario funcionario) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(funcionario);
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
    
    public boolean update(Funcionario funcionario) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(funcionario);
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
