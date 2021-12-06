package fr.epita.services.data.jpa;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GenericJPADAO<T> {

    @Inject
    SessionFactory factory;

    public void create(T object){

        Session session = factory.openSession();
        session.save(object);
        session.close();
    }

    public void update(T obj){
        Session session = factory.openSession();
        session.update(obj);
        session.close();
    }

    public void delete(T obj){
        Session session = factory.openSession();
        session.delete(obj);
        session.close();
    }


}
