import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 모눈종이의 크기
        int l = sc.nextInt() / 2; // 그물의 길이
        int m = sc.nextInt(); // 물고기의 수

        int[][] map = new int[n+1][n+1];
        Point[] points = new Point[m];

        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
            map[x][y] = 1;
        }

        int max = 0;

        for(Point p : points) {
            for(int width=1; width<=l-1; width++) {
                int height = l - width;

                for(int x=p.x-width; x<=p.x; x++) {
                    if(x<0 || x+width>n) break;
                    for(int y=p.y-height; y<=p.y; y++) {
                        if(y<0 || y+height>n) break;
                        max = Math.max(max, countFish(map, x, y, x+width, y+height));
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int countFish(int[][] map, int start_x, int start_y, int end_x, int end_y) {
        int cnt = 0;

        for(int x=start_x; x<=end_x; x++)
            for(int y=start_y; y<=end_y; y++)
                cnt += map[x][y];

        return cnt;
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
}