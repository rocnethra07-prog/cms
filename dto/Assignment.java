package simple_course.dto;

import simple_course.util.IdGenerator;

public abstract class Assignment {

    private String id;
    private String title;
    private String description;
    private int totalMarks;

    public Assignment(String title, String description, int marks){
        this.id = IdGenerator.generateAssignmentId();
        this.title = title;
        this.description = description;
        this.totalMarks = marks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    abstract String getType();
    abstract void start();
    abstract int[] doAssignment(Assignment a);

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

}

