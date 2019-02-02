import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for(int j=0; j<m; j++)
                arr[j] = sc.nextInt();

            long sum = 0; // int 로 하면 넘어갈 수 있음 (문제 조건 참고)
            for(int j=0; j<m; j++) {
                for(int k=j+1; k<m;k++) {
                    sum += gcd_loop(arr[j], arr[k]);
                }
            }
            System.out.println(sum);
        }
    }

    public static int gcd_loop(int a, int b) {
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

}