import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[][] map = new int[n][m];
        cams = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] >= 1 && map[i][j] <= 5)
                    cams.add(new Camera(i, j, map[i][j]));
            }
        }

        dfs(map, 0);

        System.out.println(answer);
    }

    public static int n;
    public static int m;
    public static List<Camera> cams;
    public static int answer = Integer.MAX_VALUE;


    public static void dfs(int[][] map, int camIdx) {
        // Á¾·á Á¶°Ç
        if(camIdx == cams.size()) {
            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            answer = Integer.min(answer, cnt);
            return;
        }

        Camera c = cams.get(camIdx);

        if(c.type == 1) {
            dfs(up(map, c.x, c.y), camIdx+1);
            dfs(down(map, c.x, c.y), camIdx+1);
            dfs(left(map, c.x, c.y), camIdx+1);
            dfs(right(map, c.x, c.y), camIdx+1);
        }

        else if(c.type == 2) {
            dfs(down(up(map, c.x, c.y), c.x, c.y), camIdx+1);
            dfs(right(left(map, c.x, c.y), c.x, c.y), camIdx+1);
        }

        else if(c.type == 3) {
            dfs(right(up(map, c.x, c.y), c.x, c.y), camIdx+1);
            dfs(right(down(map, c.x, c.y), c.x, c.y), camIdx+1);
            dfs(left(up(map, c.x, c.y), c.x, c.y), camIdx+1);
            dfs(left(down(map, c.x, c.y), c.x, c.y), camIdx+1);
        }

        else if(c.type == 4) {
            dfs(left(right(up(map, c.x, c.y), c.x, c.y), c.x, c.y), camIdx+1);
            dfs(left(right(down(map, c.x, c.y), c.x, c.y), c.x, c.y), camIdx+1);
            dfs(right(down(up(map, c.x, c.y), c.x, c.y), c.x, c.y), camIdx+1);
            dfs(left(down(up(map, c.x, c.y), c.x, c.y), c.x, c.y), camIdx+1);
        }

        else if(c.type == 5) {
            dfs(down(left(right(up(map, c.x, c.y), c.x, c.y), c.x, c.y), c.x, c.y), camIdx+1);
        }


    }


    public static int[][] up(int[][] map_source, int x, int y) {

        // ¸Ê º¹»ç
        int[][] map = map_source.clone();
        for(int i=0; i<map_source.length; i++) {
            map[i] = map_source[i].clone();
        }

        while(--x >= 0) {
            if(map[x][y] == 6)
                break;
            if(map[x][y] == 0)
                map[x][y] = 7;
        }

        return map;
    }

    public static int[][] down(int[][] map_source, int x, int y) {

        // ¸Ê º¹»ç
        int[][] map = map_source.clone();
        for(int i=0; i<map_source.length; i++) {
            map[i] = map_source[i].clone();
        }

        while(++x < n) {
            if(map[x][y] == 6)
                break;
            if(map[x][y] == 0)
                map[x][y] = 7;
        }

        return map;
    }

    public static int[][] left(int[][] map_source, int x, int y) {

        // ¸Ê º¹»ç
        int[][] map = map_source.clone();
        for(int i=0; i<map_source.length; i++) {
            map[i] = map_source[i].clone();
        }

        while(--y >= 0) {
            if(map[x][y] == 6)
                break;
            if(map[x][y] == 0)
                map[x][y] = 7;
        }

        return map;
    }

    public static int[][] right(int[][] map_source, int x, int y) {

        // ¸Ê º¹»ç
        int[][] map = map_source.clone();
        for(int i=0; i<map_source.length; i++) {
            map[i] = map_source[i].clone();
        }

        while(++y < m) {
            if(map[x][y] == 6)
                break;
            if(map[x][y] == 0)
                map[x][y] = 7;
        }

        return map;
    }
}


class Camera {
    int x,y,type;
    Camera(int x, int y, int type) {this.x=x; this.y=y; this.type=type;}
}
