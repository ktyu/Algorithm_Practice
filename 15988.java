import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcnum = sc.nextInt();
        long[] d = new long[1000001];
        d[1] = 1;
        d[2] = d[1] + 1;
        d[3] = d[1] + d[2] + 1;

        for(int tcidx=0; tcidx<tcnum; tcidx++) {

            int n = sc.nextInt();

            if(d[n] != 0) {
                System.out.println(d[n]);
                continue;
            }

            for(int i=4; i<n+1; i++) {
                if(d[i] != 0)
                    continue;

                d[i] = d[i-1] % 1000000009 + d[i-2] % 1000000009 + d[i-3] % 1000000009;
                d[i] %= 1000000009;
            }

            System.out.println(d[n]);
        }
    }
}