package fr.epita.quiz.services.data.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.services.data.api.IDAO;

public  class GenericJPADAO<T> implements IDAO<T>{

    @Inject
    SessionFactory factory;

    @Override
    public void create(T object){

        Session session = factory.openSession();
        session.save(object);
        session.close();
    }

    @Override
    public void update(T obj){
        Session session = factory.openSession();
        session.update(obj);
        session.close();
    }

    @Override
    public void delete(T obj){
        Session session = factory.openSession();
        session.delete(obj);
        session.close();
    }

    @Override
    public List<T> search(T obj) {
        return null;
    }


}
