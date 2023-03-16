import java.util.Scanner;

public class ConsoleUserInput implements UserInput{
    public int read(int minValue, int maxValue) {
        Scanner scanner = new Scanner(System.in);
        int userAnswer = 0;
        while (scanner.hasNext()) {
            if (!scanner.hasNextInt()) {
                System.out.println("Not a number");
                scanner.next();
            } else {
                userAnswer = scanner.nextInt();
                if (userAnswer >= minValue && userAnswer <= maxValue) {
                    break;
                } else {
                    System.out.println("Out of range");
                }
            }
        }
        return userAnswer;
    }
}
