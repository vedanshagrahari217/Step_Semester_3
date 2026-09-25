public class q4 {

    static class HallTicket {

        String studentName;
        int seatNumber;

        HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {

        HallTicket priya =
            new HallTicket("Priya", 0);

        // Second variable points to the same object
        HallTicket copy = priya;

        // Change through second variable
        copy.seatNumber = 45;

        System.out.println(
            "Priya's seatNumber (via first variable): "
            + priya.seatNumber
        );

        System.out.println(
            "copy == priya: " + (copy == priya)
        );

        // Separate object with same field values
        HallTicket separate =
            new HallTicket("Priya", 45);

        System.out.println(
            "separate == priya: " + (separate == priya)
        );
    }
}