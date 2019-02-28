import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] p = new int[n+1];

        for(int i=1; i<=n; i++) {
            p[i] = sc.nextInt();

            for(int j=1; j<i; j++) {
                int temp = p[j] + p[i-j];
                if(p[i] > temp)
                    p[i] = temp;
            }
        }

        System.out.println(p[n]);
    }
}