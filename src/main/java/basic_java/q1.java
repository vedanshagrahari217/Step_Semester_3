import java.util.Scanner;

abstract class Seat {
    protected int count;

    public Seat(int count) {
        this.count = count;
    }

    public abstract double calculateAmount();
}

class RegularSeat extends Seat {
    public RegularSeat(int count) {
        super(count);
    }

    @Override
    public double calculateAmount() {
        return count * (150 + 20);
    }
}

class PremiumSeat extends Seat {
    public PremiumSeat(int count) {
        super(count);
    }

    @Override
    public double calculateAmount() {
        return count * (250 + 20);
    }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(int count) {
        super(count);
    }

    @Override
    public double calculateAmount() {
        return count * (400 + 20);
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int count = sc.nextInt();

            Seat seat;

            switch (type) {
                case "REGULAR":
                    seat = new RegularSeat(count);
                    break;

                case "PREMIUM":
                    seat = new PremiumSeat(count);
                    break;

                case "RECLINER":
                    seat = new ReclinerSeat(count);
                    break;

                default:
                    System.out.println("Invalid Seat Type");
                    continue;
            }

            double amount = seat.calculateAmount();
            total += amount;

            System.out.printf("%s: %.2f%n", type, amount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}