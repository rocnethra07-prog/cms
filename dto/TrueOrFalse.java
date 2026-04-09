package simple_course.dto;

public class TrueOrFalse {
    private String question;
    private boolean answer;

    public TrueOrFalse(String question, boolean answer){
        this.question = question;
        this.answer = answer;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
