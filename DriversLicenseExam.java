import java.util.Scanner;

public class DriversLicenseExam {
    private static final char[] correctAnswers = {
        'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
        'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'
    };
    
    private char[] studentAnswers;
    
    public DriversLicenseExam(char[] studentAnswers) {
        this.studentAnswers = studentAnswers;
    }
    
    public boolean passed() {
        return totalCorrect() >= 15;
    }
    
    public int totalCorrect() {
        int correctCount = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (studentAnswers[i] == correctAnswers[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }
    
    public int totalIncorrect() {
        return correctAnswers.length - totalCorrect();
    }
    
    public int[] questionsMissed() {
        int[] missedQuestions = new int[totalIncorrect()];
        int index = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (studentAnswers[i] != correctAnswers[i]) {
                missedQuestions[index++] = i + 1;
            }
        }
        return missedQuestions;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] studentAnswers = new char[20];
        
        System.out.println("Enter the student's answers (A, B, C, or D): ");
        for (int i = 0; i < studentAnswers.length; i++) {
            char answer;
            do {
                System.out.print("Question " + (i + 1) + ": ");
                answer = scanner.next().toUpperCase().charAt(0);
            } while (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D');
            studentAnswers[i] = answer;
        }
        
        DriversLicenseExam exam = new DriversLicenseExam(studentAnswers);
        
        System.out.println("The student " + (exam.passed() ? "passed" : "failed") + " the exam.");
        System.out.println("Total correct answers: " + exam.totalCorrect());
        System.out.println("Total incorrect answers: " + exam.totalIncorrect());
        
        int[] missedQuestions = exam.questionsMissed();
        if (missedQuestions.length > 0) {
            System.out.print("Questions missed: ");
            for (int missed : missedQuestions) {
                System.out.print(missed + " ");
            }
        } else {
            System.out.println("No questions missed.");
        }
    }
}
