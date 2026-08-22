import java.util.Scanner;
public class q4 {
   static void sumofNaturalNumbers(int n){
    int sum=0;
    int i=1;
    while(i<=n){
        sum = sum + i;
        i++;
    }
    System.out.println("Sum of first " + n + " natural numbers is: " + sum);
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        sumofNaturalNumbers(n);
    }
}
