package simple_course.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrueOrFalseModel extends Assignment {
    private List<TrueOrFalse> listoftrueorfalse;

    public TrueOrFalseModel(String title, String description, int marks) {
        super(title, description, marks);
        this.listoftrueorfalse = new ArrayList<>();
    }

    public List<TrueOrFalse> getListoftrueorfalse() {
        return listoftrueorfalse;
    }

    public void setListoftrueorfalse(List<TrueOrFalse> listoftrueorfalse) {
        this.listoftrueorfalse = listoftrueorfalse;
    }

    public String getType() {
        return "True or False Model";
    }

    public void start() {
        System.out.println("\nStarting: " + getTitle() );
        System.out.println("Description: " + getDescription());
        System.out.println("Total Marks: " + getTotalMarks());

        int score = 0, total = 0;

        int[] res = doAssignment(this);
        score = res[0];
        total = res[1];

        int finalScore = (total == 0) ? 0 : (int) Math.round((double) score / total * getTotalMarks());
        System.out.println("\nAssignment Complete!");
        System.out.println("Correct: " + score + " / " + total);
        System.out.println("Score:   " + finalScore );
    }

    public int[] doAssignment(Assignment t) {
        TrueOrFalseModel model = (TrueOrFalseModel) t;
        int correct = 0;
        List<TrueOrFalse> questions = model.getListoftrueorfalse();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            TrueOrFalse q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestion());
            System.out.print("Your answer (true/false): ");
            boolean ans = sc.nextLine().trim().equalsIgnoreCase("true");
            if (ans == q.isAnswer()) {
                System.out.println("Correct!");
                correct++;
            }
            else System.out.println("Wrong. Correct answer: " + q.isAnswer());
        }
        return new int[]{correct, questions.size()};
    }

    public void addTrueOrFalse(TrueOrFalse tf) {
        this.listoftrueorfalse.add(tf);
    }

}
