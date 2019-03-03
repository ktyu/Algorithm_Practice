import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int mod = 1000000000;

        int [][] d = new int[k+1][n+1];

        d[0][0] = 1;

        for(int i=1; i<k+1; i++) {
            for(int j=0; j<n+1; j++) {
                for(int x=0; x<=j; x++) {
                    d[i][j] += d[i-1][j-x];
                    d[i][j] %= mod;
                }
            }
        }

        System.out.println(d[k][n]);
    }
}