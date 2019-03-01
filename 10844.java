import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n+1][10];

        for(int i=1; i<10; i++)
            arr[1][i] = 1;

        int mod = 1000000000;


        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                if(j==0) {
                    arr[i][1] += arr[i-1][j];
                    arr[i][1] %= mod;
                }

                else if(j==9) {
                    arr[i][8] += arr[i-1][j];
                    arr[i][8] %= mod;
                }

                else {
                    arr[i][j-1] += arr[i-1][j];
                    arr[i][j+1] += arr[i-1][j];
                    arr[i][j-1] %= mod;
                    arr[i][j+1] %= mod;
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