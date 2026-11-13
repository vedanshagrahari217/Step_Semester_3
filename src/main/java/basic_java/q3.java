import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10) + 200;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            Room room;

            switch (type) {
                case "SINGLE":
                    int singleUnits = sc.nextInt();
                    room = new SingleRoom(singleUnits);
                    break;

                case "SHARED":
                    int sharedUnits = sc.nextInt();
                    int occupants = sc.nextInt();
                    room = new SharedRoom(sharedUnits, occupants);
                    break;

                case "AC":
                    int acUnits = sc.nextInt();
                    room = new ACRoom(acUnits);
                    break;

                default:
                    System.out.println("Invalid Room Type");
                    continue;
            }

            double bill = room.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}