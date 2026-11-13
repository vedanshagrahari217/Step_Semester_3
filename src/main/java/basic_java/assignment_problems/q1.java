public class q1 {

    public static String[] rotateRoster(String[] names, int k) {

        int n = names.length;
        k = k % n; // handle k > n

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {

        String[] names = {"A", "B", "C", "D", "E"};
        int k = 2;

        String[] rotated = rotateRoster(names, k);

        for (String name : rotated) {
            System.out.print(name + " ");
        }
    }
}