import java.util.Scanner;

abstract class Cab {
    protected int km;
    protected String time;

    public Cab(int km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double calculateFare();
}

class MiniCab extends Cab {

    public MiniCab(int km, String time) {
        super(km, time);
    }

    @Override
    public double calculateFare() {
        double fare = km * 10;
        return Math.max(fare, 100);
    }
}

class SedanCab extends Cab {

    public SedanCab(int km, String time) {
        super(km, time);
    }

    @Override
    public double calculateFare() {
        double fare = km * 14;
        fare = Math.max(fare, 100);

        if (time.equalsIgnoreCase("NIGHT")) {
            fare += fare * 0.20;
        }

        return fare;
    }
}

class SUVCab extends Cab {

    public SUVCab(int km, String time) {
        super(km, time);
    }

    @Override
    public double calculateFare() {
        double fare = km * 18;
        fare = Math.max(fare, 100);

        if (time.equalsIgnoreCase("NIGHT")) {
            fare += fare * 0.20;
        }

        return fare;
    }
}

public class q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {

            String cabType = sc.next().toUpperCase();
            int km = sc.nextInt();
            String time = sc.next().toUpperCase();

            Cab cab = null;

            switch (cabType) {
                case "MINI":
                    if (time.equals("NIGHT")) {
                        System.out.println("MINI: Night service not available");
                        continue;
                    }
                    cab = new MiniCab(km, time);
                    break;

                case "SEDAN":
                    cab = new SedanCab(km, time);
                    break;

                case "SUV":
                    cab = new SUVCab(km, time);
                    break;

                default:
                    System.out.println("Invalid Cab Type");
                    continue;
            }

            double fare = cab.calculateFare();
            total += fare;

            System.out.printf("%s: %.2f%n", cabType, fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}