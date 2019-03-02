import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[][][] drink = new int[n][2][2]; // 잔 순서, 이전 잔 시음여부, 지금 잔 시음여부

        drink[0][0][1] = arr[0];
        drink[0][1][1] = arr[0];

        if(n >= 2) {
            drink[1][0][1] = arr[1];
            drink[1][1][0] = arr[0];
            drink[1][1][1] = arr[0]+arr[1];
        }

        for(int i=2; i<n; i++) {
            drink[i][0][0] = Math.max(drink[i-1][0][0], drink[i-1][1][0]);
            drink[i][1][0] = Math.max(drink[i-1][0][1], drink[i-1][1][1]);

            drink[i][0][1] = Math.max(drink[i-1][0][0], drink[i-1][1][0]) + arr[i];
            drink[i][1][1] = drink[i-1][0][1] + arr[i];
        }

        System.out.println(Math.max(drink[n-1][1][1], Math.max(drink[n-1][0][1], drink[n-1][1][0])));
    }
}