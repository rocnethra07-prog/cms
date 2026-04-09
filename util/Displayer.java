package simple_course.util;

import simple_course.dto.*;

public class Displayer {
    public static void printCourseSummary(Course c) {
        System.out.println("  [" + c.getId() + "]  " + c.getName()
                + "  |  " + c.getDescription()
                + "  |  Lessons: " + c.getLessons().size()
                + "  |  Assignments: " + c.getAssignments().size()
                + "  |  Students: " + c.getStudents().size());
    }

    public static void printLessonDetail(Lesson l) {
        System.out.println("\n--- Lesson Detail ---");
        System.out.println("ID      : " + l.getId());
        System.out.println("Index   : #" + l.getIndex());
        System.out.println("Title   : " + l.getTitle());
        System.out.println("Content : " + l.getContent());
        if (l.getVideoURL() != null && !l.getVideoURL().isEmpty())
            System.out.println("Video   : " + l.getVideoURL());
    }

    public static void printAssignmentDetail(Assignment a) {
        System.out.println("\n Assignment Detail");
        System.out.println("ID          : " + a.getId());
        System.out.println("Title       : " + a.getTitle());
        System.out.println("Description : " + a.getDescription());
        System.out.println("Total Marks : " + a.getTotalMarks());

        if (a instanceof MCQModel) {
            MCQModel mcqs = (MCQModel) a;
            int n = 1;
            for (MCQ mcq : mcqs.getListofmcqs()) {
                System.out.println("  Q" + n++ + ": " + mcq.getQuestion());
                for (Choice ch : mcq.getChoices()) {
                    System.out.println("     " + ch.getChoice());
                }
                System.out.println("  Answer: " + mcq.getCorrect().getChoice());
            }
        }
        else if (a instanceof TrueOrFalseModel) {
            TrueOrFalseModel m = (TrueOrFalseModel) a;
            int n = 1;
            for (TrueOrFalse q : m.getListoftrueorfalse()) {
                System.out.println("  Q" + n++ + ": " + q.getQuestion());
                System.out.println("  Answer: " + q.isAnswer());
            }
        }
        else if (a instanceof FillInModel) {
            FillInModel m = (FillInModel) a;
            int n = 1;
            for (FillIn q : m.getListoffillups()) {
                System.out.println("  Q" + n++ + ": " + q.getQuestion());
                System.out.println("  Answer: " + q.getAnswer());
            }
        }
    }
}