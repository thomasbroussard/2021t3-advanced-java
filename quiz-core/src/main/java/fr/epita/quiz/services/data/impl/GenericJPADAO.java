package fr.epita.quiz.services.data.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.services.data.api.IDAO;

public  class GenericJPADAO<T> implements IDAO<T>{

    @Inject
    protected SessionFactory factory;

    @Override
    public void create(T object){
        Session session = factory.getCurrentSession();
        session.save(object);
    }

    @Override
    public void update(T obj){
        Session session = factory.getCurrentSession();
        session.update(obj);
    }

    @Override
    public void delete(T obj){
        Session session = factory.getCurrentSession();
        session.delete(obj);
    }

    @Override
    public List<T> search(T obj) {
        return null;
    }


}
