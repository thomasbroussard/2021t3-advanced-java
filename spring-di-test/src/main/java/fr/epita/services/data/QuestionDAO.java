package fr.epita.services.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import fr.epita.datamodel.Question;


@Service("questionJdbcDAO")
public class QuestionDAO {

    DataSource dataSource;

    public void create(Question question) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO QUESTIONS (title) values (?)");
            preparedStatement.setString(1, question.getQuestionTitle());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
