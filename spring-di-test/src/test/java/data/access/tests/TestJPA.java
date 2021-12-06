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

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;
import fr.epita.services.data.jpa.MCQChoiceJPADAO;
import fr.epita.services.data.jpa.QuestionJPADAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAHibernateSpringConfig.class})
public class TestJPA {

    @Inject
    SessionFactory sessionFactory;

    @Inject
    MCQChoiceJPADAO mcqChoiceJPADAO;

    @Inject
    QuestionJPADAO questionJPADAO;

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


    @Test
    public void testMCQChoiceDAO(){
        Question ques = new Question();
        questionJPADAO.create(ques);
        MCQChoice mcqChoice = new MCQChoice();
        mcqChoice.setQuestion(ques);
        mcqChoiceJPADAO.create(mcqChoice);


    }



}
