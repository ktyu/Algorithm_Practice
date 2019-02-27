import java.util.*;

public class Main {

    public static int recursive(int arr[], int n) {

        if(n==1) // Smallest Problem
            return 0;

        if(arr[n] != 1000001) // DP !!!
            return arr[n];


        if(n % 3 == 0)
            arr[n] = Math.min(arr[n], recursive(arr, n/3) + 1);

        if(n % 2 == 0)
            arr[n] = Math.min(arr[n], recursive(arr, n/2) + 1);

        arr[n] = Math.min(arr[n], recursive(arr, n-1) + 1);

        return arr[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr;

        if (n < 4)
            arr = new int[4];
        else
            arr = new int[n + 1];

        Arrays.fill(arr, 1000001);


        // Top-Down 풀이 (재귀함수 호출)
//        System.out.println(recursive(arr, n));


        // Bottom-Up 풀이 (반복문 사용)
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for(int i=4; i<n+1; i++) {
            if(i % 3 == 0)
                arr[i] = Math.min(arr[i], arr[i/3]+1);

            if(i % 2 == 0)
                arr[i] = Math.min(arr[i], arr[i/2]+1);

            arr[i] = Math.min(arr[i], arr[i-1]+1);
        }
        System.out.println(arr[n]);


    }
}