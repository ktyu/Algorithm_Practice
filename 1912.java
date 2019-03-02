import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[] maxSeqSum = new int[n];
        maxSeqSum[0] = arr[0];

        for(int i=1; i<n; i++) {
            maxSeqSum[i] = Math.max(maxSeqSum[i-1]+arr[i], arr[i]);
        }

        int answer = -999999999;
        for(int val : maxSeqSum)
            answer = Math.max(answer, val);
        System.out.println(answer);
    }
}