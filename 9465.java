import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcnum = sc.nextInt();

        while (tcnum-- > 0) {

            int n = sc.nextInt();
            int[][] arr = new int[n+1][2];
            for(int i=1; i<=n; i++) arr[i][0] = sc.nextInt();
            for(int i=1; i<=n; i++) arr[i][1] = sc.nextInt();


            // 0 - ¾È¶âÀ½
            // 1 - À§¿¡²¬ ¶âÀ½
            // 2 - ¾Æ·¡²¬ ¶âÀ½
            int[][] score = new int[n+1][3];

            for(int i=1; i<=n; i++) {
                score[i][0] = Math.max(Math.max(score[i-1][0], score[i-1][1]), score[i-1][2]);
                score[i][1] = Math.max(score[i-1][0], score[i-1][2]) + arr[i][0];
                score[i][2] = Math.max(score[i-1][0], score[i-1][1]) + arr[i][1];
            }

            System.out.println(Math.max(Math.max(score[n][0], score[n][1]), score[n][2]));
        }
    }
}