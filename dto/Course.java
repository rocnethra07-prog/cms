package simple_course.dto;

import simple_course.util.IdGenerator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Course {

    private String id;
    private String name;
    private String description;
    private User instructor;
    private Set<User> students;

    private List<Assignment> assignments;
    private List<Lesson> lessons;
    private Set<Category> categorySet ;

    public Course(String name, String description, User instructor, Set<Category> categories){
        this.id = IdGenerator.generateCourseId();
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.lessons = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.students = new LinkedHashSet<>();
        this.categorySet = categories;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson less){
        this.lessons.add(less);
    }

    public void addStudent(User u){
        this.students.add(u);
    }
}
