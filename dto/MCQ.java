package simple_course.dto;

import java.util.List;

public class MCQ {
    private String question ;
    private List<Choice> choices;
    private Choice correct ;

    public MCQ(String question, List<Choice> choices , Choice correct){
        this.question= question;
        this.choices = choices;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Choice getCorrect() {
        return correct;
    }

    public void setCorrect(Choice correct) {
        this.correct = correct;
    }
}


