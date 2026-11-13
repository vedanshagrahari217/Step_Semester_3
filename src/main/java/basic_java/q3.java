import java.util.Scanner;

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();

    public String getName() {
        return name;
    }
}

class DayScholar extends Student {

    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 40000 + 12000; // Tuition + Transport
    }
}

class Hosteller extends Student {

    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 40000 + 60000; // Tuition + Hostel
    }
}

class ScholarStudent extends Student {

    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 20000 + 12000; // Half Tuition + Transport
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new ScholarStudent(name);
                    break;

                default:
                    System.out.println("Invalid Student Type");
                    continue;
            }

            double fee = student.calculateFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", student.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}