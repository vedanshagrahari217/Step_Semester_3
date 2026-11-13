import java.util.Arrays;

public class q1 {

    public static void lineUp(int[] heights) {

        int pass = 1;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < heights.length - 1; i++) {

                if (heights[i] > heights[i + 1]) {

                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " +
                    Arrays.toString(heights));

            pass++;

        } while (swapped);
    }

    public static void main(String[] args) {

        int[] heights = {4, 2, 5, 1};

        lineUp(heights);
    }
}
