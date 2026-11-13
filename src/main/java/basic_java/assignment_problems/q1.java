

import java.util.Scanner;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount + 10; // service charge
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = null;

            switch (type.toUpperCase()) {
                case "STUDENT":
                    customer = new Student(amount);
                    break;
                case "STAFF":
                    customer = new Staff(amount);
                    break;
                case "GUEST":
                    customer = new Guest(amount);
                    break;
            }

            double finalAmount = customer.calculateFinalAmount();
            total += finalAmount;

            System.out.printf("%s: %.2f%n", type.toUpperCase(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}