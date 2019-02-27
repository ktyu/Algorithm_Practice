import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcnum = sc.nextInt();
        int[] d = new int[11];
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

                d[i] = d[i-1] + d[i-2] + d[i-3];
            }

            System.out.println(d[n]);
        }
    }
}