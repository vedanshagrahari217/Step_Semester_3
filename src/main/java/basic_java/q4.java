import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {

    public InternEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return 2000;
    }
}

public class q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            switch (type.toUpperCase()) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;

                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;

                case "INTERN":
                    employee = new InternEmployee(name, salary);
                    break;

                default:
                    System.out.println("Invalid Employee Type");
                    continue;
            }

            double bonus = employee.calculateBonus();
            totalBonus += bonus;

            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}