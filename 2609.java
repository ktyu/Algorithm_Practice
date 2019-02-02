import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd1 = gcd_recursive(a,b);
        int gcd2 = gcd_loop(a,b);

        int lcm = (a*b) / gcd1;

        if(gcd1 != gcd2)
            System.exit(-1);

        System.out.println(gcd1);
        System.out.println(lcm);

    }

    public static int gcd_recursive(int a, int b) {
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }


        if(b==0)
            return a;

        return gcd_recursive(b, a%b);
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
