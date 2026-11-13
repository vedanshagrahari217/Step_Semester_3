import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10; // service charge
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student(amount);
                    break;

                case "STAFF":
                    customer = new Staff(amount);
                    break;

                case "GUEST":
                    customer = new Guest(amount);
                    break;

                default:
                    System.out.println("Invalid customer type");
                    continue;
            }

            double finalAmount = customer.calculateFinalAmount();
            total += finalAmount;

            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}