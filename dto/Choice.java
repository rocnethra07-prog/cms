package simple_course.dto;

public class Choice{

    //TODO -- Same class and variable name.
    //TODO -- Why no equals and hashcode method?
    private String choice;
    public Choice(String choice){
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    //TODO -- Should choice be mutable? Is setChoice method required? Make the field final - Thread-safe.
    public void setChoice(String choice) {
        this.choice = choice;
    }
}

//TODO -- Since this class only wraps a single String, why didn't you just use List<String> choices inside the MCQ class