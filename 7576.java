import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][m];
        List<Point> riped = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] nums = sc.nextLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                int tomato = Integer.valueOf(nums[j]);
                map[i][j] = tomato;
                if (tomato == 1) {
                    riped.add(new Point(i, j));
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int day = 0;
        Queue<Point> q = new LinkedList<>();
        for (Point p : riped)
            q.offer(p);

        int x, y;
        while (!(q.isEmpty())) {
            int cnt = q.size();
            boolean changed = false;

            for (int a = 0; a < cnt; a++) {
                Point p = q.poll();

                for (int i = 0; i < 4; i++) {
                    x = p.x + dx[i];
                    y = p.y + dy[i];

                    if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 1 || map[x][y] == -1)
                        continue;

                    map[x][y] = 1;
                    q.offer(new Point(x, y));
                    changed = true;
                }
            }

            if(changed)
                day += 1;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day);
    }
}

class Point {
    int x,y;
    public Point(int x, int y) {this.x=x; this.y=y;}
}
