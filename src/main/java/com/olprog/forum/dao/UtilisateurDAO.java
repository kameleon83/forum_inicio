package com.olprog.forum.dao;

import com.olprog.forum.entities.UtilisateurEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UtilisateurDAO {

    private Session session;

    public UtilisateurDAO(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public void createOrUpdate(UtilisateurEntity utilisateurEntity){
        session.beginTransaction();
        session.save(utilisateurEntity);
        session.getTransaction().commit();
        session.close();
    }

    public List<UtilisateurEntity> read(){
        List<UtilisateurEntity> users = session.createQuery("from UtilisateurEntity").list();
        session.close();
        return users;
    }

    public void delete(UtilisateurEntity utilisateurEntity){
        session.beginTransaction();
        session.delete(utilisateurEntity);
        session.getTransaction().commit();
        session.close();
    }

    public UtilisateurEntity findById(UtilisateurEntity utilisateurEntity, Long id){
        Object o = null;
        session.beginTransaction();
        o = session.get(UtilisateurEntity.class, id);
        session.beginTransaction().commit();
        session.close();
        return (UtilisateurEntity) o;
    }
}
