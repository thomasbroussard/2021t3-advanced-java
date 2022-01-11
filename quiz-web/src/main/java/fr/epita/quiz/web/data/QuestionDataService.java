package fr.epita.quiz.web.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.data.api.IMCQQuestionDAO;
import fr.epita.quiz.services.data.api.IQuestionDAO;
import fr.epita.quiz.web.dto.MCQChoiceDTO;
import fr.epita.quiz.web.dto.QuestionDTO;

@Component
public class QuestionDataService {

    @Inject
    IMCQQuestionDAO choiceDAO;

    @Inject
    IQuestionDAO questionDAO;





    @Transactional
    public void saveMcqQuestion(QuestionDTO questionDTO) //should throw functional exceptions
    {

        if (questionDTO == null) {
            //inconsistency to report
            //TODO throw exception
            return;
        }
        List<MCQChoiceDTO> choiceDTOList = questionDTO.getChoices();
        if (choiceDTOList == null || choiceDTOList.isEmpty()) {
            //inconsistency to report
            //TODO throw exception
            return;
        }


        //Conversion from external to internal
        Question question = new Question();
        question.setQuestionTitle(questionDTO.getQuestion());

        List<MCQChoice> mcqChoices = new ArrayList<>();
        for (MCQChoiceDTO mcqChoiceDTO : choiceDTOList){
            MCQChoice mcqChoice = new MCQChoice();
            mcqChoice.setQuestion(question);
            mcqChoice.setChoiceTitle(mcqChoiceDTO.getStatement());
            mcqChoice.setValid(mcqChoiceDTO.isValid());
            mcqChoices.add(mcqChoice);
        }


        // data access
        //from internal datamodel to database
        questionDAO.create(question);

        //exaclty same as the regular for each loop
        mcqChoices.forEach(choiceDAO::create);

    }

    public List<QuestionDTO> getQuestionByTitle(String title) {

        // Data access part
        Question question = new Question();
        question.setQuestionTitle(title);
        MCQChoice choice = new MCQChoice();
        choice.setQuestion(question);
        List<MCQChoice> results = this.choiceDAO.search(choice);

        Map<Question, List<MCQChoice>> groupedByQuestion = results.stream().collect(Collectors.groupingBy(MCQChoice::getQuestion));

        // DTO conversion part
        List<QuestionDTO> returnedQuestions = new ArrayList<>();

        for (Map.Entry<Question,List<MCQChoice>> entry : groupedByQuestion.entrySet()){
            QuestionDTO dto = new QuestionDTO();
            Question currentQuestion = entry.getKey();

            dto.setQuestion(currentQuestion.getQuestionTitle());
            List<MCQChoice> mcqChoices = entry.getValue();
            List<MCQChoiceDTO> dtoChoices = new ArrayList<>();
            for (MCQChoice mcqChoice : mcqChoices ){
                MCQChoiceDTO mcqChoiceDTO = new MCQChoiceDTO();
                mcqChoiceDTO.setValid(mcqChoice.isValid());
                mcqChoiceDTO.setStatement(mcqChoice.getChoiceTitle());
                dtoChoices.add(mcqChoiceDTO);
            }

            dto.setChoices(dtoChoices);
            returnedQuestions.add(dto);
        }

        return returnedQuestions;



    }
}
