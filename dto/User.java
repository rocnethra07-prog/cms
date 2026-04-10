package simple_course.dto;

import simple_course.util.IdGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;

    private Set<Course> createdCourses ;
    private Set<Course> enrolledCourses ;

    private Mode mode;

    //TODO : Created Courses will always be empty for students. Is this correct?
    //TODO : Do we need to maintain the list of created and enrolled courses in the user class?
    //TODO : Do we need to maintain the password in the user class?
    //TODO : Do we need to maintain the email in the user class? Or can we use the id as the unique identifier for the user?
    //Why mode is not used ?
    public User(String name, String email, String password){
        this.id = IdGenerator.generateUserId();
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdCourses = new HashSet<>();
        this.enrolledCourses = new HashSet<>();
    }

    public void addCreatedCourse(Course c){
        this.createdCourses.add(c);
    }

    public void addEnrolledCourse(Course c){
        this.enrolledCourses.add(c);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Course> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(Set<Course> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(Set<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setMode(String mode) {
        try {
            this.mode = Mode.valueOf(mode.toUpperCase());
        }
        catch (Exception e) {
            //TODO -- Catching a generic Exception to handle a failed Enum parsing is a bad practice. It should specifically catch IllegalArgumentException so it doesn't accidentally swallow other underlying system errors.
            System.out.println("Invalid mode: " + mode);
        }
    }

    public String toString(){
        return "{ User : " + this.id + ", Name : "+ this.name + ", Mode : " +this.mode + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || (!(obj instanceof User))) return false;
        User u = (User)obj;
        return u.email.equals(this.email);
    }

    @Override
    public int hashCode() {
        //TODO -- We are using email as the unique identifier for the user. Is this correct? What happens when email ID changes for the user?
        return Objects.hash(this.email);
    }
}
