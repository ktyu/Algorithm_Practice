import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String wh = sc.nextLine().trim();
            if (wh.equals("0 0")) {
                break;
            }

            String[] nums = wh.split(" ");
            int w = Integer.valueOf(nums[0]);
            int h = Integer.valueOf(nums[1]);

            int[][] map = new int[w][h];
            for (int y = 0; y < h; y++) {
                nums = sc.nextLine().trim().split(" ");
                for (int x = 0; x < w; x++) {
                    map[x][y] = Integer.valueOf(nums[x]);
                }
            }

            int cnt = 0;
            for(int y=0; y<h; y++) {
                for(int x=0; x<w; x++) {
                    if(map[x][y] == 1) {
                        bfs(map, x, y, w, h);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }


    public static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public static int bfs(int[][]map, int x, int y, int w, int h) {

        Queue<Point> q = new LinkedList<>();
        int cnt = 1;
        map[x][y] = 0;
        q.offer(new Point(x,y));


        while(!(q.isEmpty())) {
            Point p = q.poll();
            x = p.x;
            y = p.y;

            // 8개 방향검사
            for(int i=0; i<8; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx < 0 || xx >= w)
                    continue;
                if (yy < 0 || yy >= h)
                    continue;

                if (map[xx][yy] == 1) {
                    cnt++;
                    map[xx][yy] = 0;
                    q.offer(new Point(xx,yy));
                }
            }
        }

        return cnt;
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {this.x = x; this.y = y;}
}
