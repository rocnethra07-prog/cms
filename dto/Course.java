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
    //TODO -- Course - instructor bidirectional responsibility. modifying one side should ideally update the other to prevent inconsistent states.
    private User instructor;

    //TODO: Why students, categoryset is set and assignments, lessons in list?
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

    //TODO -- Why setId if this.id = IdGenerator.generateCourseId(); - what if I change the id of the course after creating it ? Is this correct?
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

    //TODO -- setStudents, setLessons, setAssignments - Do we need these setter methods? addLesson(), addAssignment() methods should be sufficient.
    public void setStudents(Set<User> students) {
        this.students = students;
    }

    //TODO -- Encapsulation leak - what if some I do course.getAssignments().clear(). Return unmodifiable list.
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

    //TODO -- Why no equals and hashcode method? What if two same courses created?

    /**
     Course course1 = new Course("Java 101", "ABC", instructor, categories);
     course1.setId("course-1");

     Course course2 = new Course("Java 101", "ABC", instructor, categories);
     course2.setId("course-1");

     Set<Course> enrolledCourses = new HashSet<>();
     enrolledCourses.add(course1);
     enrolledCourses.add(course2);
     *
     */
}
