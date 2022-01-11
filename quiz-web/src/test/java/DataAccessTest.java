import java.sql.SQLException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.web.data.QuestionDataService;
import fr.epita.quiz.web.dto.MCQChoiceDTO;
import fr.epita.quiz.web.dto.QuestionDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBSpringConfig.class })
@Commit //to actually commit the transaction
public class DataAccessTest {

    @Inject
    QuestionDataService questionDS;

    @Inject
    DataSource dataSource;


    @Test
    @Transactional
    public void testCreation(){
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestion("test?");
        MCQChoiceDTO choiceDTO = new MCQChoiceDTO();
        choiceDTO.setStatement("is this a choiceDTO?");
        questionDTO.setChoices(Arrays.asList(choiceDTO));
        this.questionDS.saveMcqQuestion(questionDTO);
    }

    @After
    public void after() throws SQLException {


    }

}
