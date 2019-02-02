import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        for(int i=0; i<n; i++) {
            if(isPrime(sc.nextInt()))
                cnt += 1;
        }
        System.out.println(cnt);

    }

    public static boolean isPrime(int n) {
        if(n<2)
            return false;

        for(int i=2; i*i<=n; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

}