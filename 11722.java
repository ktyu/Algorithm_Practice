import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[] cnt = new int[n];
        cnt[0] = 1;

        for(int i=1; i<n; i++) {
            cnt[i] = 1;

            for(int j=i-1; j>=0; j--) {
                if(arr[j] > arr[i] && cnt[i] < cnt[j] + 1)
                    cnt[i] = cnt[j] + 1;
            }
        }


        int answer = 0;
        for(int val : cnt)
            if(answer < val)
                answer = val;
        System.out.println(answer);
    }
}