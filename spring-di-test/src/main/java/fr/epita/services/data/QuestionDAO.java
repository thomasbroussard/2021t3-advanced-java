package fr.epita.services.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fr.epita.datamodel.Question;


@Service("questionJdbcDAO")
public class QuestionDAO {

    @Inject
    @Named("dataSource")
    DataSource dataSource;

    public void create(Question question) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.setString(1, question.getQuestionTitle());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
