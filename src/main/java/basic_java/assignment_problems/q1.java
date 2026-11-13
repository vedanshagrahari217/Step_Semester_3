public class q1 {

    public static int countInBand(int[] scores, int low, int high) {

        int left = firstGreaterOrEqual(scores, low);
        int right = firstGreater(scores, high);

        return right - left;
    }

    private static int firstGreaterOrEqual(int[] scores, int target) {

        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int firstGreater(int[] scores, int target) {

        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        int low = 42;
        int high = 58;

        System.out.println(countInBand(scores, low, high));
    }
}