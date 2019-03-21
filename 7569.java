import java.util.*;

public class Main {

    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[][][] tomato = new int[m][n][h];
        int rawTomatoCnt = 0;

        Queue<Point> q = new LinkedList<>();
        int answer = 1;

        for(int k=0; k<h; k++) {
            for(int j=0; j<n; j++) {
                for(int i=0; i<m; i++) {
                    tomato[i][j][k] = sc.nextInt();

                    // 익은 토마토면 큐에 삽입
                    if(tomato[i][j][k] == 1)
                        q.add(new Point(i, j ,k));

                    // 안익은 토마토면 갯수 가운팅
                    else if(tomato[i][j][k] == 0)
                        rawTomatoCnt++;
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.remove();

            for(int i=0; i<6; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                int z = p.z + dz[i];

                if(x<0 || x>=m || y<0 || y>=n || z<0 || z>=h || tomato[x][y][z] == -1)
                    continue;

                if(tomato[x][y][z] == 0) {
                    tomato[x][y][z] = tomato[p.x][p.y][p.z] + 1;
                    answer = tomato[x][y][z];
                    rawTomatoCnt--;
                    q.add(new Point(x, y, z));
                }

            }
        }

        if(rawTomatoCnt != 0)
            System.out.println(-1);
        else
            System.out.println(answer-1);
    }
}

class Point {
    int x, y, z;
    Point(int x, int y, int z) {this.x=x; this.y=y; this.z=z;}
}