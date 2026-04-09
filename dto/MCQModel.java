package simple_course.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MCQModel extends Assignment {
    private List<MCQ> listofmcqs;

    public MCQModel(String title, String description, int marks) {
        super(title, description, marks);
        this.listofmcqs = new ArrayList<>();
    }

    public List<MCQ> getListofmcqs() {
        return listofmcqs;
    }

    public void setListofmcqs(List<MCQ> listofmcqs) {
        this.listofmcqs = listofmcqs;
    }

    public String getType() {
        return "MCQ Model";
    }

    public void start() {

        System.out.println("\nStarting: " + getTitle());
        System.out.println("Description: " + getDescription());
        System.out.println("Total Marks: " + getTotalMarks());

        int score = 0, total = 0;

        int[] res = doAssignment(this);
        score = res[0];
        total = res[1];

        int finalScore = (total == 0) ? 0 : (int) Math.round((double) score / total * getTotalMarks());
        System.out.println("\nAssignment Complete!");
        System.out.println("Correct: " + score + " / " + total);
        System.out.println("Score:   " + finalScore);
    }

    public int[] doAssignment(Assignment m) {

        MCQModel model = (MCQModel)m;
        Scanner sc = new Scanner(System.in);
        int correct = 0;
        List<MCQ> questions = model.getListofmcqs();
        for (int i = 0; i < questions.size(); i++) {
            MCQ q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestion());
            for (Choice ch : q.getChoices()) {
                System.out.println("   " + ch.getChoice());
            }
            System.out.print("Your answer (A/B/C/D): ");
            int idx = "ABCD".indexOf(sc.nextLine().trim().toUpperCase());
            boolean isCorrect =  q.getChoices().get(idx).getChoice().equals(q.getCorrect().getChoice());
            if (isCorrect) {
                System.out.println("Correct!"); correct++;
            }
            else System.out.println("Wrong. Correct answer: " + q.getCorrect().getChoice());
        }
        return new int[]{correct, questions.size()};
    }

    public void addMCQ(MCQ mcq) {
        this.listofmcqs.add(mcq);
    }

}
