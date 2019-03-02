import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[] maxSum = new int[n];
        maxSum[0] = arr[0];

        for(int i=1; i<n; i++) {
            maxSum[i] = arr[i];

            for(int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i] && maxSum[i] < maxSum[j] + arr[i])
                    maxSum[i] = maxSum[j] + arr[i];
            }
        }


        int answer = 0;
        for(int val : maxSum)
            if(answer < val)
                answer = val;
        System.out.println(answer);
    }
}