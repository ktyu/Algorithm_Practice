import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int delCnt = 0;

        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);

        for(int i=2; i<=n; i++) {
            if(arr[i]) {
                int num = 0;
                while(++num <= n) {
                    if (num * i < arr.length && arr[num * i]) {
                        arr[num * i] = false;
                        if (++delCnt == k) {
                            System.out.println(num * i);
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}
