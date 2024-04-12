import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to online store!");
        System.out.println("What's the credit card balance? ");
        double balance = scanner.nextDouble();

        CreditCard creditCard = new CreditCard(balance);

        byte exit = 1;
        while (exit != 0) {
            System.out.println("What are you buying? ");
            String description = scanner.next();

            System.out.println("Value: ");
            double value = scanner.nextDouble();

            Buy buy = new Buy(description, value);
            boolean purchaseCompleted = creditCard.trolley(buy);

            if (purchaseCompleted) {
                System.out.println("Purchase completed!");
                System.out.println("""
                       [0] Exit
                       [1] Continue
                        """);
                exit = scanner.nextByte();
            } else {
                System.out.println("Insufficient balance!");
                exit = 0;
            }

            System.out.println("--------------------------");
            System.out.println("Finished!\n");

            Collections.sort(creditCard.getBuy());

            for (Buy item : creditCard.getBuy()) {
                System.out.println(item.getDescription() + " - " + item.getValue());
            }

            System.out.println("\n--------------------------");
            System.out.printf("\nBalance of the credit card: $%.1f", creditCard.getBalance());
        }
    }
}
