package data.access.tests;


import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.datamodel.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAHibernateSpringConfig.class})
public class TestJPA {

    @Inject
    SessionFactory sessionFactory;

    @Test
    public void testCreationUsingHibernate(){
        Session session = sessionFactory.openSession();
        Question question = new Question();
        question.setQuestionTitle("test?");

        Transaction transaction = session.beginTransaction();
        session.save(question);
        transaction.commit();

        Query<Question> from_question = session.createQuery("from Question q where q.questionTitle = 'test?'", Question.class);
        List<Question> allQuestions = from_question.list();
        Question foundQuestion = allQuestions.get(0);
        Assert.assertEquals(foundQuestion.getQuestionTitle(), "test?");
    }



}
