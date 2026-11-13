public class q1 {

    public static int[] attendanceSummary(int[] days) {

        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {

            if (day == 1) {
                presentCount++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentCount, longestStreak};
    }

    public static void main(String[] args) {

        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0] +
                           ", Longest streak: " + result[1]);
    }
}