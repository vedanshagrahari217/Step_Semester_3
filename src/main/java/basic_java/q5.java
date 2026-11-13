import java.util.Scanner;

abstract class Appliance {
    protected int hours;
    protected boolean saverMode;

    public Appliance(int hours, boolean saverMode) {
        this.hours = hours;
        this.saverMode = saverMode;
    }

    public abstract double getPower();

    public boolean supportsSaverMode() {
        return false;
    }

    public double calculateUnits() {
        double units = (getPower() * hours) / 1000.0;

        if (saverMode && supportsSaverMode()) {
            units = units * 0.75; // 25% reduction
        }

        return units;
    }

    public double calculateCost() {
        return calculateUnits() * 8;
    }
}

class Fridge extends Appliance {

    public Fridge(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 150;
    }
}

class AC extends Appliance {

    public AC(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 1500;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

class TV extends Appliance {

    public TV(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 100;
    }
}

class Washer extends Appliance {

    public Washer(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 500;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

public class q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();

            boolean saver = false;
            if (sc.hasNextLine()) {
                String remaining = sc.nextLine().trim();
                if (remaining.equalsIgnoreCase("SAVER")) {
                    saver = true;
                }
            }

            Appliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours, saver);
                    break;

                case "AC":
                    appliance = new AC(hours, saver);
                    break;

                case "TV":
                    appliance = new TV(hours, saver);
                    break;

                case "WASHER":
                    appliance = new Washer(hours, saver);
                    break;

                default:
                    System.out.println("Invalid Appliance");
                    continue;
            }

            if (saver && !appliance.supportsSaverMode()) {
                System.out.printf("%s: Saver mode not supported%n", type);
                continue;
            }

            double units = appliance.calculateUnits();
            double cost = appliance.calculateCost();

            totalCost += cost;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}