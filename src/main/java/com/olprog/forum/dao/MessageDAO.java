package com.olprog.forum.dao;

import com.olprog.forum.entities.MessageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MessageDAO {

    private Session session;

    public MessageDAO(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public void createOrUpdate(MessageEntity messageEntity){
        session.beginTransaction();
        session.save(messageEntity);
        session.getTransaction().commit();
        session.close();
    }

    public List<MessageEntity> read(){
        List<MessageEntity> messages = session.createQuery("from MessageEntity").list();
        session.close();
        return messages;
    }

    public void delete(MessageEntity messageEntity){
        session.beginTransaction();
        session.delete(messageEntity);
        session.getTransaction().commit();
        session.close();
    }

    public MessageEntity findById(MessageEntity messageEntity, Long id){
        Object o = null;
        session.beginTransaction();
        o = session.get(MessageEntity.class, id);
        session.beginTransaction().commit();
        session.close();
        return (MessageEntity) o;
    }
}
