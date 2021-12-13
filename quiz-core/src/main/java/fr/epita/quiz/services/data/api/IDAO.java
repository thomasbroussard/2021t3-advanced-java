package fr.epita.quiz.services.data.api;

import java.util.List;

public interface IDAO<T> {
    void create(T object);

    void update(T obj);

    void delete(T obj);

    List<T> search (T obj);
}
