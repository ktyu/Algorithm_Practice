import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] d = new int[n+1];
        d[1] = 1;

        for(int i=2; i<n+1; i++) {

            int x = 1;
            int min = Integer.MAX_VALUE;
            while(i-x*x >=0) {
                min = Math.min(min, d[i-x*x]);
                x++;
            }
            d[i] = min + 1;
        }
        System.out.println(d[n]);
    }
}