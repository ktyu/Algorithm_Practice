import java.util.*;

public class Solution {

        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcnum = sc.nextInt();
        int cnt = tcnum;

        while(--cnt >= 0) {

            int[][] map = new int[4][4];

            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            s = new HashSet<>();

            // 모든 점에서 해봐야함
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {

                    go(map, i, j, "");

                }
            }

            System.out.println("#" + (tcnum-cnt) + " " + s.size());
        }
    }

    public static HashSet<String> s;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void go(int[][] map, int xx, int yy, String str) {

        if(str.length() == 7) {
            s.add(str);
            return;
        }

        for(int i=0; i<4; i++) {
            int x = xx + dx[i];
            int y = yy + dy[i];

            if(x<0 || x>3 || y<0 || y>3)
                continue;

            go(map, x, y, str + map[x][y]);
        }

    }
}