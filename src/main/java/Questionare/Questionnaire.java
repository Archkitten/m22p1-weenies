package Questionare;
import java.util.Scanner;
public class Questionnaire {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String want;
        System.out.print("Hello. Welcome to our website!");
        System.out.println("Please answer the following questions to begin");
        System.out.println("Do you want to lose or gain weight?");
        want = sc.nextLine();
        System.out.print("\nHow old are you?");
        Double age = sc.nextDouble();
        System.out.print("\nHow tall are you (please specify in total inches)");
        double height = sc.nextDouble();
        System.out.print("\nHow much do you weigh? (please specify in total pounds)");
        double weight = sc.nextDouble();
        System.out.print("\nWhat is your goal weight?");
        Double goal = sc.nextDouble();
    }
}


