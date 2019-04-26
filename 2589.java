import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x,y;
        Point(int x, int y) {this.x=x; this.y=y;}
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];

        ArrayList<Point> lands = new ArrayList<>();

        for(int i=0; i<h; i++) {
            String str = br.readLine();
            for(int j=0; j<w; j++) {
                if(str.charAt(j) == 'L') {
                    map[i][j] = 1;
                    lands.add(new Point(i, j));
                }
            }
        }

        for(Point p : lands) {
            bfs(map, p);
        }

        System.out.println(answer);
    }

    static int answer = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int[][] map, Point start) {
        int[][] cost = new int[map.length][map[0].length];

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        cost[start.x][start.y] = 1;

        while(!q.isEmpty()) {
            Point p = q.remove();
            answer = Integer.max(answer, cost[p.x][p.y] - 1);

            for(int i=0; i<4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if(x<0 || x>=map.length || y<0 || y>=map[0].length)
                    continue;

                if(cost[x][y] == 0 && map[x][y] == 1) {
                    cost[x][y] = cost[p.x][p.y] + 1;
                    q.add(new Point(x, y));
                }
            }
        }
    }
}