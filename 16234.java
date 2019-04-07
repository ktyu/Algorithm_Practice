import java.util.*;

public class Main {

    static class Point {
        int x,y;
        Point(int x, int y) {this.x=x; this.y=y;}
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int day = 0;
        boolean changed;

        // 현재 map의 상태에서 에서 연합을 이룰 것들을 검사
        do {
            changed = false;
            check = new boolean[n][n];
            int[][] map_new = new int[n][n];

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    // 아래 재귀호출 도중에 연합을 이뤄낸 국가이면 다시 방문할 필요없음
                    if(check[i][j])
                        continue;

                    // 연합을 이룰 국가들의 리스트
                    List<Point> union = new ArrayList<>();
                    union.add(new Point(i, j));
                    check[i][j] = true;

                    // 연합 가능한 국가를 DFS로 찾고 없으면 끝
                    dfs(union, i, j);
                    if(union.size() == 1)
                        continue;

                    // 국경을 열어야할 나라들이 존재하는 경우 map_new에 기록
                    changed = true;
                    int sum = 0;
                    for(Point p : union) {
                        sum += map[p.x][p.y];
                    }
                    sum /= union.size();

                    for(Point p : union) {
                        map_new[p.x][p.y] = sum;
                    }
                }
            }

            // 연합하지 못한 국가는 기존의 값을 덮어씀
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if (map_new[i][j] == 0)
                        map_new[i][j] = map[i][j];
                }
            }

            // 새 맵으로 갱신하고, 바뀐점이 있는지 체크
            map = map_new;
            if(changed)
                day++;

        } while(changed);

        
        System.out.println(day);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static int l;
    static int r;

    static boolean[][] check;
    static int[][] map;

    static void dfs(List<Point> union, int x, int y) {

        for(int i=0; i<4; i++) {
            int xx = x+dx[i];
            int yy = y+dy[i];

            if(xx<0 || xx>=n || yy<0 || yy>=n || check[xx][yy])
                continue;

            int val = Math.abs(map[x][y] - map[xx][yy]);
            if(l <= val && val <= r) {
                union.add(new Point(xx, yy));
                check[xx][yy] = true;
                dfs(union, xx, yy);
            }
        }
    }
}