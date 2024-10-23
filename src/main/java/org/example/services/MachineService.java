package org.example.services;



import org.example.dao.IDao;
import org.example.entities.Machine;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class MachineService implements IDao<Machine> {

    @Override
    public boolean create(Machine machine) {
        Session session = null;
        Transaction tx = null;
        boolean etat =false;

        try{
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(machine);
            tx.commit();
            etat = true;
        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
        }
        finally {
            if (session!=null) session.close();
        }
        return etat;
    }
    @Override
    public boolean update(Machine machine) {
        Session session = null;
        Transaction tx = null;
        boolean etat =false;

        try{
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(machine);
            tx.commit();
            etat = true;
        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
        }
        finally {
            if (session!=null) session.close();
        }
        return etat;
    }
    @Override
    public boolean delete(Machine machine) {
        Session session = null;
        Transaction tx = null;
        boolean etat =false;

        try{
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(machine);
            tx.commit();
            etat = true;
        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
        }
        finally {
            if (session!=null) session.close();
        }
        return etat;
    }
    @Override
    public Machine getById(int id) {
        Session session = null;
        Transaction tx = null;
        Machine machine = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machine = session.get(Machine.class, id);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return machine;
    }
    @Override
    public List<Machine> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Machine> machines = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machines=session.createQuery("from Machine",Machine.class).list();
            tx.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return machines;
    }

    public List<Machine> findBetweenDate(Date d1, Date d2){
        Session session = null;
        Transaction tx = null;
        List<Machine> machines = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machines=session.getNamedQuery("findBetweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return machines;
    }
}

