import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    public Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate getRenewalDate();

    public String getName() {
        return name;
    }
}

class BasicPlan extends Plan {

    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Plan {

    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Plan {

    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String planType = sc.next();
            String name = sc.next();
            String dateStr = sc.next();

            LocalDate startDate = LocalDate.parse(dateStr);

            Plan plan;

            switch (planType.toUpperCase()) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;

                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;

                case "PREMIUM":
                    plan = new PremiumPlan(name, startDate);
                    break;

                default:
                    System.out.println("Invalid Plan Type");
                    continue;
            }

            System.out.println(plan.getName() + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}