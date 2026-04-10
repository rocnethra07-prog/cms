package simple_course.dto;

import java.util.List;

public class MCQ {
    private String question ;
    private List<Choice> choices;
    private Choice correct ;

    public MCQ(String question, List<Choice> choices , Choice correct){
        //TODO -- What is correct choice is not in list of choices?
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

    //TODO -- What if correct is not in choices? Is this correct?
    public Choice getCorrect() {
        return correct;
    }

    public void setCorrect(Choice correct) {
        this.correct = correct;
    }

    //TODO - evaluateAnswer should be done here instead of MCQModel.java
}


