import java.util.Random;
import java.util.Scanner;

public class Lottery {
    private int[] lotteryNumbers;
    
    public Lottery() {
        lotteryNumbers = new int[5];
        generateLotteryNumbers();
    }
    
    private void generateLotteryNumbers() {
        Random random = new Random();
        for (int i = 0; i < lotteryNumbers.length; i++) {
            lotteryNumbers[i] = random.nextInt(10);
        }
    }
    
    public int compareNumbers(int[] userNumbers) {
        int matchCount = 0;
        for (int i = 0; i < lotteryNumbers.length; i++) {
            if (lotteryNumbers[i] == userNumbers[i]) {
                matchCount++;
            }
        }
        return matchCount;
    }
    
    public int[] getLotteryNumbers() {
        return lotteryNumbers.clone();
    }
    
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        Scanner scanner = new Scanner(System.in);
        int[] userNumbers = new int[5];
        
        System.out.println("Enter your lottery picks (five numbers between 0 and 9): ");
        for (int i = 0; i < userNumbers.length; i++) {
            int pick;
            do {
                System.out.print("Number " + (i + 1) + ": ");
                pick = scanner.nextInt();
            } while (pick < 0 || pick > 9);
            userNumbers[i] = pick;
        }
        
        int matchCount = lottery.compareNumbers(userNumbers);
        int[] lotteryNumbers = lottery.getLotteryNumbers();
        
        System.out.print("Lottery numbers: ");
        for (int num : lotteryNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("Your picks: ");
        for (int num : userNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("You have " + matchCount + " matching digits.");
        if (matchCount == 5) {
            System.out.println("Congratulations! You are the grand prize winner!");
        }
    }
}
