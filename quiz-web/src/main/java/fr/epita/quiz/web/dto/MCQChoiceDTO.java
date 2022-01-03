package fr.epita.quiz.web.dto;

public class MCQChoiceDTO {

    private boolean valid;
    private String statement;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
