import java.util.Scanner;
public class q1{
    static void isCheckVotingEligibility(int n){
             boolean isAdult = (n>=18);
   if(isAdult){
    System.out.println("eligible to vote");
   }
   else{
    System.out.println("not eligible to vote");
   }   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the age : ");
        int age = sc.nextInt();
        isCheckVotingEligibility(age);
    }
}