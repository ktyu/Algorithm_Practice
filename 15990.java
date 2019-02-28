import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[][] cases = new int[100001][4];

        cases[1][1] = 1;

        cases[2][2] = 1;

        cases[3][1] = 1;
        cases[3][2] = 1;
        cases[3][3] = 1;

        for(int tc=0; tc<t; tc++) {
            int n = sc.nextInt();

            for(int i=4; i<=n; i++) {
                if(cases[i][1]+cases[i][2]+cases[i][3] != 0)
                    continue;

                cases[i][1] = cases[i-1][2] % 1000000009 + cases[i-1][3]  % 1000000009;
                cases[i][1] %= 1000000009;

                cases[i][2] = cases[i-2][1] % 1000000009 + cases[i-2][3]  % 1000000009;
                cases[i][2] %= 1000000009;

                cases[i][3] = cases[i-3][1] % 1000000009 + cases[i-3][2] % 1000000009;
                cases[i][3] %= 1000000009;
            }

            int answer = (cases[n][1] + cases[n][2]) % 1000000009 + cases[n][3];
            System.out.println(answer % 1000000009);
        }

    }
}