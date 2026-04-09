package simple_course.main;

import simple_course.dto.*;
import simple_course.util.Displayer;

import java.util.*;

public class NewMainClass {

    static List<Course> allCourses = new ArrayList<>();
    static User student = new User("Nethra" , "nethra@gmail.com" , "1234");
    static User instructor = new User("Kavya", "kavya@gmail.com", "5678");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("--Course Management Console App--");

        boolean flag = true;

        while(flag){
            System.out.println("1. Login as Instructor");
            System.out.println("2. Login as Student");
            System.out.println("0. Exit");
            System.out.print("Choose : ");
            String opt = sc.nextLine().trim();

            switch(opt){
                case "1":
                    instructorMenu();
                    break;
                case "2":
                    studentMenu();
                    break;
                case "0":
                    System.out.println("Bye...");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void instructorMenu(){
        boolean back = false;
        while(!back){
            System.out.println("--- Instructor Menu [ " + instructor.getName()+ " ] ---");
            System.out.println("1. Course Management");
            System.out.println("2. Lesson Management");
            System.out.println("3. Assignment Management");
            System.out.println("4. View my Created Courses");
            System.out.println("0. Back");

            System.out.print("Choose : ");
            switch(sc.nextLine().trim()){
                case "1":
                    courseCrudMenu();
                    break;
                case "2":
                    lessonCrudMenu();
                    break;
                case "3":
                    assignmentCrudMenu();
                    break;
                case "4":
                    viewCreatedCourses();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }


    public static void studentMenu(){
        boolean back = false;
        while(!back){
            System.out.println("--- Student Menu [" + student.getName() + " ] ---" );
            System.out.println("1. Browse all courses");
            System.out.println("2. Enroll in a course");
            System.out.println("3. My Enrolled Courses");
            System.out.println("4. View course details and lessons");
            System.out.println("5. Do an assignment");
            System.out.println("6. Back");

            System.out.print("Choose: ");
            switch (sc.nextLine().trim()){
                case "1":
                    viewAllCourse();
                    break;
                case "2":
                    enrollNewCourse();
                    break;
                case "3":
                    viewEnrolledCourses();
                    break;
                case "4":
                    studentViewCourseDetails();
                    break;
                case "5":
                    startAssignment();
                case "0":
                    back = true;
                    break;
                default :
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    //INSTRUCTOR OPERATIONS :

    public static void courseCrudMenu(){
        boolean back = false;
        while(!back){
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Create Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            switch(sc.nextLine().trim()){
                case "1":
                    createCourse();
                    break;
                case "2":
                    viewAllCourse();
                    break;
                case "3":
                    updateCourse();
                    break;
                case "4":
                    deleteCourse();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void createCourse() {
        System.out.print("Course Title: ");
        String title = sc.nextLine().trim();
        System.out.print("Description: ");
        String description = sc.nextLine().trim();
        System.out.print("Categories (comma-separated): ");
        String catInput = sc.nextLine().trim();

        Set<Category> cats = new LinkedHashSet<>();
        for (String s : catInput.split(","))
            cats.add(new Category(s.trim()));

        Course c = new Course(title, description, instructor, cats);
        allCourses.add(c);
        instructor.addCreatedCourse(c);
        System.out.println("Course created: [" + c.getId() + "] " + c.getName());
    }

    static void viewAllCourse() {
        if (allCourses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("\n--- All Courses ---");
        for (Course c : allCourses){
            Displayer.printCourseSummary(c);
        }
    }

    static void updateCourse(){
        viewAllCourse();
        if(allCourses.isEmpty()){
            System.out.println("No course available");
            return;
        }

        System.out.print("Enter Course ID to update : ");
        String id = sc.nextLine().trim();
        Course c = findCourseById(id);

        if(c == null){
            System.out.println("Course not found");
            return;
        }

        System.out.print("New Title (leave blank to keep [ " + c.getName() + " ]) : ");
        String t = sc.nextLine().trim();
        if(!t.isEmpty()){
            c.setName(t);
        }

        System.out.print("New Description (leave blank to keep current) : ");
        String d = sc.nextLine().trim();

        if(!d.isEmpty()){
            c.setDescription(d);
        }
        System.out.println("Course updated");
    }

    static void deleteCourse(){
        viewAllCourse();
        if(allCourses.isEmpty()){
            return;
        }

        System.out.print("Enter course ID to delete: ");
        Course c = findCourseById(sc.nextLine().trim());

        if(c == null){
            System.out.println("Course not found");
            return;
        }

        allCourses.remove(c);
        instructor.getCreatedCourses().remove(c);
        System.out.println("Course deleted");
    }


    //Course CRUD
    public static void lessonCrudMenu(){

        viewAllCourse();
        if(allCourses.isEmpty()){
            return;
        }
        System.out.println("Enter course ID to manage lessons : ");
        Course c = findCourseById(sc.nextLine().trim());
        if(c == null){
            System.out.println("Course not found");
            return;
        }


        boolean back = false;
        while(!back){
            System.out.println("\n--- Lesson Management --- ");
            System.out.println("1. Add Lesson");
            System.out.println("2. View all Lessons");
            System.out.println("3. View lesson detail ");
            System.out.println("4. Update lesson ");
            System.out.println("5. Delete lesson ");
            System.out.println("0. Back");
            System.out.print("Choose : ");

            switch(sc.nextLine().trim()){
                case "1":
                    addLesson(c);
                    break;
                case "2":
                    viewLessons(c);
                    break;
                case "3":
                    viewLessonDetail(c);
                    break;
                case "4":
                    updateLesson(c);
                    break;
                case "5":
                    deleteLesson(c);
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    //Lesson CRUD
    static void addLesson(Course c){
        System.out.print("Lesson Title : ");
        String title = sc.nextLine().trim();
        System.out.print("Content : ");
        String content = sc.nextLine().trim();
        System.out.print("Video URL (optional, press Enter to skip) :");
        String video = sc.nextLine().trim();

        int index = c.getLessons().size() + 1;
        Lesson l = new Lesson(title, content, index);
        if(!video.isEmpty()){
            l.setVideoURL(video);
        }

        c.addLesson(l);
        System.out.println("Lesson added " + l);

    }

    static void viewLessons(Course c){
        if(c.getLessons().isEmpty()){
            System.out.println("No lessons in this course");
            return;
        }

        System.out.println("\n ---Lessons in " + c.getName() + " ---");
        for(Lesson l : c.getLessons()){
            System.out.println("  #"+ l.getIndex() + " " + l.getId()  + " " +l.getTitle());
        }
    }

    static void viewLessonDetail(Course c){
        viewLessons(c);
        if(c.getLessons().isEmpty()){
            return;
        }

        System.out.print("Enter Lesson ID to view ");
        String id = sc.nextLine().trim();
        Lesson l = findLessonById(c, id);

        if(l == null){
            System.out.println("Lesson not found");
            return;
        }

        Displayer.printLessonDetail(l);

    }

    static void updateLesson(Course c){
        viewLessons(c);
        if(c.getLessons().isEmpty()){
            return;
        }

        System.out.print("Enter lesson ID to update : ");
        Lesson l = findLessonById(c, sc.nextLine().trim());
        if(l == null){
            System.out.println("Lesson not found");
            return;
        }

        System.out.print("New Title (leave blank to keep current ["+l.getTitle() + "]) :");
        String t= sc.nextLine().trim();
        if(!t.isEmpty()){
            l.setTitle(t);
        }

        System.out.print("New content (leave blank to keep current) :");
        String con = sc.nextLine().trim();

        if(!con.isEmpty()){
            l.setContent(con);
        }

        System.out.print("New Video URL : " );
        String url = sc.nextLine().trim();

        if(!url.isEmpty()){
            l.setVideoURL(url);
        }
        System.out.println("Lesson updated. ");
    }

    static void deleteLesson(Course c) {
        viewLessons(c);
        if (c.getLessons().isEmpty()) {
            return;
        }
        System.out.print("Enter lesson ID to delete : ");
        String id = sc.nextLine().trim();

        Lesson l = findLessonById(c,id);

        if(l == null){
            System.out.println("Lesson not found");
            return;
        }
        c.getLessons().remove(l);

        int index = 1;
        for(Lesson lsn : c.getLessons()){
            lsn.setIndex(index++);
        }

        System.out.println("Lesson deleted.");
    }

    public static void assignmentCrudMenu(){
        viewAllCourse();
        if(allCourses.isEmpty()){
            return;
        }
        System.out.println("Enter course ID to manage assignments : ");
        Course c = findCourseById(sc.nextLine().trim());
        if(c == null){
            System.out.println("Course not found");
            return;
        }


        boolean back = false;
        while(!back){
            System.out.println("\n--- Assignment Management ---");
            System.out.println("1. Create Assignment");
            System.out.println("2. View All Assignments");
            System.out.println("3. View Assignment Detail");
            System.out.println("4. Update Assignment");
            System.out.println("5. Delete Assignment");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            switch(sc.nextLine().trim()){
                case "1":
                    createAssignment(c);
                    break;
                case "2":
                    viewAllAssignments(c);
                    break;
                case "3":
                    viewAssignmentDetail(c);
                    break;
                case "4":
                    updateAssignment(c);
                    break;
                case "5":
                    deleteAssignment(c);
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        }
    }

    //Assignment CRUD
    static void createAssignment(Course c){
        System.out.print("Assignment Title: ");
        String title = sc.nextLine().trim();
        System.out.print("Description: ");
        String desc = sc.nextLine().trim();
        System.out.print("Total Marks: ");
        int marks;
        try {
            marks = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid marks.");
            return;
        }

        System.out.println("Assignment Type: 1. MCQ  2. True or False  3. Fill in the Blanks");
        System.out.print("Choose type: ");
        String typeChoice = sc.nextLine().trim();

        Assignment assignment;
        switch (typeChoice) {
            case "1":
                MCQModel mcqModel = new MCQModel(title, desc, marks);
                buildMCQAssignment(mcqModel);
                assignment = mcqModel;
                break;
            case "2":
                TrueOrFalseModel tofModel = new TrueOrFalseModel(title, desc, marks);
                buildTrueOrFalseAssignment(tofModel);
                assignment = tofModel;
                break;
            case "3":
                FillInModel fillModel = new FillInModel(title, desc, marks);
                buildFillInAssignment(fillModel);
                assignment = fillModel;
                break;
            default:
                System.out.println("Invalid type.");
                return;
        }

        c.getAssignments().add(assignment);
        System.out.println("Assignment created: [" + assignment.getId() + "] " + assignment.getTitle());
    }

    static void viewAllAssignments(Course c){
        if(c.getAssignments().isEmpty()){
            System.out.println("No Assignments in this course");
            return;
        }

        for(Assignment a : c.getAssignments()){
            System.out.println("  [" + a.getId() + "]  " + a.getTitle() + " Marks: " + a.getTotalMarks());
        }
    }

    static void viewAssignmentDetail(Course c){
        viewAllAssignments(c);
        if(c.getAssignments().isEmpty()){
            System.out.println("No Assignments in this course");
            return;
        }

        System.out.print("Enter assignment ID to view: ");
        String id = sc.nextLine().trim();

        Assignment a = findAssignmentById(c, id);

        if(a == null){
            System.out.println("Assignment not found");
            return;
        }

        Displayer.printAssignmentDetail(a);
    }

    static void updateAssignment(Course c){
        viewAllAssignments(c);
        if(c.getAssignments().isEmpty()){
            System.out.println("No Assignments in this course");
            return;
        }

        System.out.print("Enter assignment ID to update : ");
        String id = sc.nextLine().trim();

        Assignment a = findAssignmentById(c,id);

        if(a == null){
            System.out.println("Assignment not found");
            return;
        }
        System.out.print("New Title (leave blank to keep [" + a.getTitle() + "]): ");
        String t = sc.nextLine().trim();
        if (!t.isEmpty()) a.setTitle(t);

        System.out.print("New Description (leave blank to keep current): ");
        String d = sc.nextLine().trim();
        if (!d.isEmpty()) a.setDescription(d);

        System.out.print("New Total Marks (leave blank to keep [" + a.getTotalMarks() + "]): ");
        String m = sc.nextLine().trim();
        if (!m.isEmpty()) {
            try {
                a.setTotalMarks(Integer.parseInt(m));
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid marks, skipped.");
            }
        }

        System.out.println("Assignment updated.");

    }

    static void deleteAssignment(Course c){
        viewAllAssignments(c);
        if(c.getAssignments().isEmpty()){
            System.out.println("No Assignments in this course");
            return;
        }
        System.out.print("Enter assignment ID to delete : ");
        String id = sc.nextLine().trim();

        Assignment a = findAssignmentById(c,id);

        if(a == null){
            System.out.println("Assignment not found");
            return;
        }

        c.getAssignments().remove(a);
        System.out.println("Assignment deleted");
    }


    public static void viewCreatedCourses(){
        Set<Course> created = instructor.getCreatedCourses();
        if(created.isEmpty()){
            System.out.println("No course created yet");
            return;
        }

        System.out.println("--- My Created Courses ---");
        for(Course c : created){
            Displayer.printCourseSummary(c);
        }
    }


    //STUDENT OPERATIONS :
    public static void enrollNewCourse(){
        viewAllCourse();
        if (allCourses.isEmpty()){
            return;
        }
        System.out.print("Enter Course ID to enroll: ");
        Course c = findCourseById(sc.nextLine().trim());
        if (c == null) {
            System.out.println("Course not found.");
            return;
        }
        if (c.getStudents().contains(student)) {
            System.out.println("Already enrolled.");
            return;
        }

        c.addStudent(student);
        student.addEnrolledCourse(c);
        System.out.println("Successfully enrolled in: " + c.getName());
    }

    public static void viewEnrolledCourses(){
        Set<Course> enrolled = student.getEnrolledCourses();
        if (enrolled.isEmpty()) {
            System.out.println("Not enrolled in any course yet.");
            return;
        }
        System.out.println("\n--- My Enrolled Courses ---");
        for (Course c : enrolled) {
            Displayer.printCourseSummary(c);
        }
    }

    public static void studentViewCourseDetails(){
        viewEnrolledCourses();
        if (student.getEnrolledCourses().isEmpty()) {
            return;
        }
        System.out.print("Enter Course ID to view: ");
        Course c = findCourseById(sc.nextLine().trim());
        if (c == null ) {
            System.out.println("Course not found or not enrolled."); return;
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course: " + c.getName() + " ---");
            System.out.println("1. View All Lessons");
            System.out.println("2. View Lesson Detail");
            System.out.println("3. View All Assignments");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            switch (sc.nextLine().trim()) {
                case "1":
                    viewLessons(c);
                    break;
                case "2":
                    viewLessonDetail(c);
                    break;
                case "3":
                    viewAllAssignments(c);
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void startAssignment(){
        viewEnrolledCourses();
        if(student.getEnrolledCourses().isEmpty()){
            System.out.println("No courses enrolled");
            return;
        }

        System.out.println("Enter course ID : ");
        String id = sc.nextLine().trim();

        Course c = findCourseById(id);
        if(c == null ){
            System.out.println("Course not found");
            return;
        }

        viewAllAssignments(c);
        if (c.getAssignments().isEmpty()) {
            return;
        }
        System.out.print("Enter Assignment ID to start: ");
        Assignment a = findAssignmentById(c, sc.nextLine().trim());

        if(a == null){
            System.out.println("Assignment not found");
            return ;
        }

        if (a instanceof MCQModel) {
            ((MCQModel) a).start();
        } else if (a instanceof TrueOrFalseModel) {
            ((TrueOrFalseModel) a).start();
        } else if (a instanceof FillInModel) {
            ((FillInModel) a).start();
        }

    }

    public static Course findCourseById(String id){
        for(Course c : allCourses){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public static Lesson findLessonById(Course c, String id){
        for(Lesson l : c.getLessons()){
            if(l.getId().equals(id)){
                return l;
            }
        }
        return null;
    }

    public static Assignment findAssignmentById(Course c, String id){
        for(Assignment a : c.getAssignments()){
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }


    public static void buildMCQAssignment( MCQModel mcqModel){
        System.out.print("How many MCQ questions are you going to post? ");
        String numb = sc.nextLine().trim();

        int num ;

        try{
            num = Integer.parseInt(numb);
        }
        catch(Exception e){
            num = 1;
        }

        for(int i=1 ; i<=num ; i++){
            System.out.println("Question "+ i + ":");
            System.out.print("Question :");
            String question = sc.nextLine().trim();
            List<Choice> choices = new ArrayList<>();
            for(String s : new String[]{"A","B","C","D"}){
                System.out.print("Option " + s + " :");
                choices.add(new Choice(sc.nextLine().trim()));
            }

            System.out.print("Correct choice (A/B/C/D) : ");
            String correct = sc.nextLine().trim().toUpperCase();
            int indx = "ABCD".indexOf(correct);

            Choice crtChoice = choices.get(indx);

            mcqModel.addMCQ(new MCQ(question, choices, crtChoice));
        }

    }

    public static void buildFillInAssignment(FillInModel fillModel){
        System.out.print("How many questions are you going to post? ");
        String number = sc.nextLine().trim();

        int num;
        try{
            num = Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            num =1 ;
        }

        for(int i=1 ; i<=num ;i++){
            System.out.println("Question " + i + ": ");
            System.out.print( "Question (use ___ for blank):");
            String question = sc.nextLine().trim();

            System.out.print("Answer : ");
            String answer = sc.nextLine().trim();

            fillModel.addFillUps(new FillIn(question, answer));

        }

    }

    public static void buildTrueOrFalseAssignment(TrueOrFalseModel tofModel){
        System.out.print("How many questions are you going to post? ");
        String number = sc.nextLine().trim();

        int num;
        try{
            num = Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            num =1 ;
        }

        for(int i=1 ; i<=num ;i++){
            System.out.println("Question " + i + ": ");
            System.out.print( "Question :");
            String question = sc.nextLine().trim();

            System.out.print("Answer (true/false) : ");
            String answer = sc.nextLine().trim();

            boolean ans = answer.equalsIgnoreCase("true");

            tofModel.addTrueOrFalse(new TrueOrFalse(question, ans));

        }
    }
}