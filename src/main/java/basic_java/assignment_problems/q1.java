import java.util.Scanner;

public class q1 {

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass
        int product = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product = product * nums[i];
        }

        // Backward pass
        product = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] answer = productExceptSelf(nums);

        System.out.println("Output:");

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }

        sc.close();
    }
}