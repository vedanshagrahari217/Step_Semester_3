import java.util.Scanner;
public class q2 {
    static void classifyNumber(int n){
        if(n>0){
            System.out.println("Positive number");
        }
        else if(n<0){
            System.out.println("Negative number");
        }
        else{
            System.out.println("Zero");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        classifyNumber(n);
    }
}
