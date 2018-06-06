package com.olprog.forum.dao;

import com.olprog.forum.entities.CategorieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CategorieDAO {

    private Session session;

    public CategorieDAO(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public void createOrUpdate(CategorieEntity categorieEntity){
        session.beginTransaction();
        session.save(categorieEntity);
        session.getTransaction().commit();
        session.close();
    }

    public List<CategorieEntity> read(){
        List<CategorieEntity> cats = session.createQuery("from CategorieEntity").list();
        session.close();
        return cats;
    }

    public void delete(CategorieEntity categorieEntity){
        session.beginTransaction();
        session.delete(categorieEntity);
        session.getTransaction().commit();
        session.close();
    }

    public CategorieEntity findById(Long id){
        Object o = null;
        session.beginTransaction();
        o = session.get(CategorieEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return (CategorieEntity) o;
    }
}
