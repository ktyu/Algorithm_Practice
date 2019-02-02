import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int gcd = gcd_loop(a,b);
            System.out.println((a*b) / gcd);
        }
    }

    public static int gcd_loop(int a, int b) {
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

}
