import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n+1][10];

        for(int i=0; i<10; i++)
            arr[1][i] = 1;

        int mod = 10007;


        for(int i=1; i<n; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<=j; k++) {
                    arr[i+1][j] += arr[i][k];
                    arr[i+1][j] %= mod;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<10; i++) {
            answer += arr[n][i];
            answer %= mod;
        }

        System.out.println(answer % mod);
    }
}