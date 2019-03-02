import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[] max = new int[n];
        max[0] = 1;

        for(int i=1; i<n; i++) {
            int highest = 0;
            max[i] = 1;

            for(int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i])
                    highest = Math.max(highest, max[j]);
            }

            max[i] += highest;
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            answer = Math.max(answer, max[i]);
        }
        System.out.println(answer);
    }
}