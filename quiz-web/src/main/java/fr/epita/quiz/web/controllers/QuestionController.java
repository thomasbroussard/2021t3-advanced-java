package fr.epita.quiz.web.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.epita.quiz.web.data.QuestionDataService;
import fr.epita.quiz.web.dto.MCQChoiceDTO;
import fr.epita.quiz.web.dto.QuestionDTO;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Inject
    QuestionDataService dataService;

    @GetMapping("/{topic}")
    public ResponseEntity<Object> getAllQuestionsForTopic(@PathVariable("topic") String searchedTopic) {
//        if (searchedTopic == null) {
//            return ResponseEntity.badRequest().body("the topic was empty");
//        }
//        try {
//            QuestionDTO questionDTO = new QuestionDTO();
//            questionDTO.addTopic(searchedTopic);
//            List<QuestionDTO> questionDTOList = dataService.search(questionDTO);
//            return ResponseEntity.ok().body(questionDTOList);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).build();
//        }
        return ResponseEntity.ok("connection ok");

    }
    @GetMapping()
    public ResponseEntity<Object> getAllQuestions() {

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        QuestionDTO question = new QuestionDTO();
        question.setQuestion("What is Java?");
        question.setTopics(Arrays.asList("programming","oop"));

        MCQChoiceDTO choice1 = new MCQChoiceDTO();
        choice1.setStatement("an indonesian island");
        choice1.setValid(true);

        MCQChoiceDTO choice2 = new MCQChoiceDTO();
        choice2.setStatement("a compiled programming language");
        choice2.setValid(true);
        question.setChoices(Arrays.asList(
                choice1,
                choice2
        ));
        questionDTOList.add(question);
        return ResponseEntity.ok().body(questionDTOList);
    }

    @PostMapping
    public ResponseEntity<Object> createQuestion(@RequestBody QuestionDTO questionDTO){
        System.out.println(questionDTO);
        return ResponseEntity.created(URI.create("generated-id")).build();
    }


}
