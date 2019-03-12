import java.util.*;

class Point {
    int x;
    int y;
    Point(int x, int y) {this.x=x; this.y=y;}
}

public class Main {

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Point baby = null;
        int baby_size = 2;

        // 인풋 받기
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int size = sc.nextInt();
                if(size==9) {
                    baby = new Point(i, j);
                    size = 0;
                }
                map[i][j] = size;
            }
        }

        int ate_cnt = 0;
        int answer = 0;

        // 먹을게 없을때까지 아기상어 이동 반복
        while(true) {
            Point ate = null;
            int nearest = Integer.MAX_VALUE;

            int[][] distance = new int[n][n];
            Queue<Point> q = new LinkedList<>();
            q.offer(baby);
            distance[baby.x][baby.y] = 1;

            // bfs 탐색 시작
            while(!q.isEmpty()) {
                Point p = q.poll();

                for(int i=0; i<4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];

                    // 접근 불가능하면 안감
                    if(x<0 || x>=n || y<0 || y>=n || map[x][y] > baby_size)
                        continue;

                    // 아직 방문 안한 곳만 방문
                    if(distance[x][y] == 0) {
                        distance[x][y] = distance[p.x][p.y] + 1;
                        q.offer(new Point(x, y));

                        // 먹이가 아니거나 자기랑 같아서 접근만 되고 먹을 수 없으면 그냥 끝
                        if(map[x][y] == 0 || map[x][y] == baby_size)
                            continue;

                        // 이번 먹이의 거리가 제일 가까우면 먹을거로 지정
                        if(distance[x][y] < nearest) {
                            nearest = distance[x][y];
                            ate = new Point(x, y);
                        }
                        else if(distance[x][y] == nearest) {
                            if(x < ate.x || (x == ate.x && y < ate.y))
                                ate = new Point(x, y);
                        }
                    }
                }
            }

            // 먹을 수 있는게 없으면 끝
            if(ate == null)
                break;

            // 먹고 성장여부 확인, 이동
            map[ate.x][ate.y] = 0;
            ate_cnt++;
            answer += distance[ate.x][ate.y] - 1;
            if(ate_cnt >= baby_size) {
                baby_size++;
                ate_cnt = 0;
            }
            baby.x = ate.x;
            baby.y = ate.y;
        }

        System.out.println(answer);
    }
}