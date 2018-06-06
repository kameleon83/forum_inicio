package com.olprog.forum.dao;

import com.olprog.forum.entities.SujetEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SujetDAO {

    private Session session;

    public SujetDAO(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public void createOrUpdate(SujetEntity sujetEntity){
        session.beginTransaction();
        session.save(sujetEntity);
        session.getTransaction().commit();
        session.close();
    }

    public List<SujetEntity> read(){
        List<SujetEntity> sujets = session.createQuery("from SujetEntity").list();
        session.close();
        return sujets;
    }

    public void delete(SujetEntity sujetEntity){
        session.beginTransaction();
        session.delete(sujetEntity);
        session.getTransaction().commit();
        session.close();
    }

    public SujetEntity findById(SujetEntity sujetEntity, Long id){
        Object o = null;
        session.beginTransaction();
        o = session.get(SujetEntity.class, id);
        session.beginTransaction().commit();
        session.close();
        return (SujetEntity) o;
    }
}
