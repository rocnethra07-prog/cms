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

    //TODO -- Why do we need getType method? Is this the correct way to check the type of Assignment
    public String getType() {
        return "MCQ Model";
    }

    //TODO -- Do we need 3 implementation of start?
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
        //TODO -- Getting as assignment and downcasting is not a good design.
        MCQModel model = (MCQModel)m;
        //TODO -- Garbage collection ?
        // Why multiple scanners are not recommended with new System.in instances?
        Scanner sc = new Scanner(System.in);
        int correct = 0;
        //TODO -- To access getListofmcqs() do we need assignment.
        List<MCQ> questions = model.getListofmcqs();
        for (int i = 0; i < questions.size(); i++) {
            MCQ q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestion());
            for (Choice ch : q.getChoices()) {
                System.out.println("   " + ch.getChoice());
            }
            System.out.print("Your answer (A/B/C/D): ");
            //TODO -- What if user enters invalid input ?
            int idx = "ABCD".indexOf(sc.nextLine().trim().toUpperCase());
//           TODO -- boolean isCorrectAnswer = q.evaluateAnswer(input);
            //TODO -- write equals() in choice instead of string comparison.
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
