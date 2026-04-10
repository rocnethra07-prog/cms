package simple_course.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TODO -- Models are DTOs, so should not have logic. Should we move the logic to a service class? Or is it a naming convention issue?
public class FillInModel extends Assignment {
    //TODO: Why list of fillups and not set? Can we have duplicate questions?
    //TODO: Why not a map of question and answer?
    private List<FillIn> listoffillups;

    public FillInModel(String title, String description, int marks) {
        super(title, description, marks);
        this.listoffillups = new ArrayList<>();
    }

    public List<FillIn> getListoffillups() {
        return listoffillups;
    }

    public void setListoffillups(List<FillIn> listoffillups) {
        this.listoffillups = listoffillups;
    }

    public String getType() {
        return "Fill Ups Model";
    }

    public void start() {
        System.out.println("\nStarting: " + getTitle() );
        System.out.println("Description: " + getDescription());
        System.out.println("Total Marks: " + getTotalMarks());

        int score = 0, total = 0;
        //TODO -- What if I pass like this? What happens ?
        int[] res = doAssignment(new MCQModel(getTitle(), getDescription(), getTotalMarks()));
        //TODO -- What is res[0], res[1]
        score = res[0];
        total = res[1];

        int finalScore = (total == 0) ? 0 : (int) Math.round((double) score / total * getTotalMarks());
        System.out.println("\nAssignment Complete!");
        System.out.println("Correct: " + score + " / " + total);
        System.out.println("Score:   " + finalScore );

    }

    public int[] doAssignment(Assignment f) {
        FillInModel model = (FillInModel) f;
        Scanner sc = new Scanner(System.in);
        int correct = 0;
        List<FillIn> questions = model.getListoffillups();
        for (int i = 0; i < questions.size(); i++) {
            FillIn q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestion());
            System.out.print("Your answer: ");
            String ans = sc.nextLine().trim();
            if (ans.equalsIgnoreCase(q.getAnswer())) {
                System.out.println("Correct!"); correct++;
            }
            else System.out.println("Wrong. Correct answer: " + q.getAnswer());
        }
        return new int[]{correct, questions.size()};
    }

    public void addFillUps(FillIn f) {
        this.listoffillups.add(f);
    }


}
