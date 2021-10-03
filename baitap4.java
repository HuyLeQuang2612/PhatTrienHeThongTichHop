
import java.util.Scanner;
 
public class baitap4 {
 
    public static void main(String[] args) {
        long sum = 0;
        int n;
        Scanner sc;
        do {
            System.out.println("Input n = ");
            sc = new Scanner(System.in);
            n = sc.nextInt();
        }while(n <= 0);
         
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
         
        System.out.println("Sum = " + sum);
        sc.close();
    }
}