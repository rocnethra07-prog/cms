package simple_course.util;

public class IdGenerator {
    public static long userid = 1;
    public static long courseid = 1;
    public static long categoryid = 1;
    public static long lessonid = 1;
    public static long assignmentid = 1;

    public static String generateUserId(){
        return "user-" + userid++;
    }

    public static String generateCourseId(){
        return "course-" + courseid++ ;
    }

    public static String generateCategoryId(){
        return "category-"+categoryid++;
    }

    public static String generateLessonId(){
        return "lesson-"+lessonid++;
    }

    public static String generateAssignmentId(){
        return "assignment-" + assignmentid++;
    }

}
