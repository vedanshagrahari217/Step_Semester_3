import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded method 1
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Overloaded method 2
    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Compare batting average in descending order
    @Override
    public int compareTo(Player other) {

        return Double.compare(other.battingAverage,
                              this.battingAverage);
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            boolean draftablePlayer;

            if (players[i].matchesPlayed >= 10) {
                draftablePlayer =
                    isDraftable(players[i].matchesPlayed);
            } else {
                draftablePlayer =
                    isDraftable(players[i].matchesPlayed,
                                players[i].injured);
            }

            if (draftablePlayer) {
                draftable[count] = players[i];
                count++;
            }
        }

        Player[] result = new Player[count];

        for (int i = 0; i < count; i++) {
            result[i] = draftable[i];
        }

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            output = output + (i + 1) + ". " + result[i].name;

            if (i < result.length - 1) {
                output = output + " | ";
            }
        }

        return output;
    }
}

public class q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            sc.nextLine();

            System.out.print("Enter player name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            players[i] = new Player(
                name,
                matchesPlayed,
                battingAverage,
                injured
            );
        }

        String result = Player.draftAndRank(players);

        System.out.println("Draft Ranking: " + result);

        sc.close();
    }
}