import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[] inc = new int[n];
        inc[0] = 1;

        for(int i=1; i<n; i++) {
            inc[i] = 1;

            for(int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i] && inc[i] < inc[j] + 1)
                    inc[i] = inc[j] + 1;
            }
        }


        int[] reverse_inc = new int[n];
        reverse_inc[n-1] = 1;

        for(int i=n-2; i>=0; i--) {
            reverse_inc[i] = 1;

            for(int j=i+1; j<=n-1; j++) {
                if(arr[i] > arr[j] && reverse_inc[i] < reverse_inc[j] + 1)
                    reverse_inc[i] = reverse_inc[j] + 1;
            }
        }


        int answer = 0;
        for(int i=0; i<n; i++)
            if(answer < inc[i]+reverse_inc[i])
                answer = inc[i]+reverse_inc[i];
        System.out.println(answer-1);
    }
}