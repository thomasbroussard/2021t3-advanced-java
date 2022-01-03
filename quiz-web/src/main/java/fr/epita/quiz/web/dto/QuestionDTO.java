package fr.epita.quiz.web.dto;

import java.util.List;

public class QuestionDTO {


    private String question;
    private List<String> topics;

    private List<MCQChoiceDTO> choices;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<MCQChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<MCQChoiceDTO> choices) {
        this.choices = choices;
    }
}
