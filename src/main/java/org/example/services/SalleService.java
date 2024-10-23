package org.example.services;

import org.example.dao.IDao;
import org.example.entities.Salle;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SalleService implements IDao<Salle> {

    @Override
    public boolean create(Salle salle) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(salle);
            tx.commit();
            etat = true;
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean update(Salle salle) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(salle);
            tx.commit();
            etat = true;
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }
    @Override
    public boolean delete(Salle salle) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(salle);
            tx.commit();
            etat = true;
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }
    @Override
    public Salle getById(int id) {
        Session session = null;
        Transaction tx = null;
        Salle salle = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salle=session.get(Salle.class, id);
            tx.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return salle;
    }
    @Override
    public List<Salle> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Salle> salles = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salles=session.createQuery("from Salle",Salle.class).list();
            tx.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return salles;
    }

}
