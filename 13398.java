import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[] maxSeqSumLeft = new int[n];
        maxSeqSumLeft[0] = arr[0];

        for(int i=1; i<n; i++) {
            maxSeqSumLeft[i] = Math.max(maxSeqSumLeft[i-1]+arr[i], arr[i]);
        }

        int[] maxSeqSumRight = new int[n];
        maxSeqSumRight[n-1] = arr[n-1];

        for(int i=n-2; i>=0; i--) {
            maxSeqSumRight[i] = Math.max(maxSeqSumRight[i+1]+arr[i], arr[i]);
        }

        int answer = -999999999;

        // 제거하지 않는 경우
        for(int val : maxSeqSumLeft)
            answer = Math.max(answer, val);

        // 한개 제거한 경우
        for(int i=1; i<n-1; i++) {
            answer = Math.max(answer, maxSeqSumLeft[i-1]+maxSeqSumRight[i+1]);
        }

        System.out.println(answer);
    }
}