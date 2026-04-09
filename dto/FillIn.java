package simple_course.dto;

public class FillIn {
    private String question ;
    private String answer ;
    public FillIn(String question, String answer){
        this.answer = answer;
        this.question = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
