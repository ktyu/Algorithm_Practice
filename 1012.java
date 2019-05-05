import java.util.*;

public class Main {
    static class Point {
        int x,y;
        Point(int x, int y) {this.x=x; this.y=y;}
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcCnt = sc.nextInt();

        while(tcCnt-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] map = new int[m][n];

            for(int i=0; i<k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            int cnt = 2;
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][j] == 1) {
                        Queue<Point> q = new LinkedList<>();
                        q.add(new Point(i, j));
                        map[i][j] = cnt;
                        while(!q.isEmpty()) {
                            Point p = q.remove();
                            for(int a=0; a<4; a++) {
                                int x = p.x+dx[a];
                                int y = p.y+dy[a];

                                if(x<0 || x>=m || y<0 || y>=n)
                                    continue;

                                if(map[x][y] == 1) {
                                    map[x][y] = cnt;
                                    q.add(new Point(x, y));
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }

            System.out.println(cnt-2);
        }
    }

}