import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];

        for(int i=0; i<n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        work(n, t, p, 0, 0);
        System.out.println(max);
    }

    public static int max = 0;

    public static void work(int n, int[] t, int[] p, int today, int profit) {

        if(today == n) {
            if(max < profit) {
                max = profit;
            }

            return;
        }

        if(today + t[today] <= n) // 상담완료일이 퇴사일을 넘지 않을때만 오늘의 상담실시
            work(n, t, p, today + t[today], profit + p[today]);

        work(n, t, p, today + 1, profit);
    }

}
