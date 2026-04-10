package simple_course.dto;

import simple_course.util.IdGenerator;

//TODO -- Why abstract class? Why not interface?
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

    //TODO -- Why do we need getType method? Is this the correct way to check the type of Assignment
    //TODO -- Why do we need start method? What does it do? Is this the correct way to start an assignment?
    //TODO -- Why no access modifiers? But public in implementation ?
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

