import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                arr[i][j] = sc.nextInt();

            
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dfs(i, j, 0, 0); // 이어지는 4개는 dfs로 탐색
                checkT(i, j); // ㅗ ㅜ ㅓ ㅏ 계산
            }
        }

        System.out.println(max);
    }

    static int[][] arr;
    static boolean[][] visited;
    static int max = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int cnt, int sum) {
        if(cnt == 4) {
            max = Integer.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int xx = x+dx[i];
            int yy = y+dy[i];

            if(xx<0 || xx>=arr.length || yy<0 || yy>=arr[0].length)
                continue;

            visited[x][y] = true;
            if(!visited[xx][yy])
                dfs(xx, yy, cnt+1, sum+arr[x][y]);
            visited[x][y] = false;
        }
    }

    static void checkT(int x, int y) {
        int var;

        // 위 3개
        if (x-1 >= 0 && y+1 < arr[0].length && y-1 >= 0) {
            var = arr[x][y] + arr[x-1][y-1] + arr[x-1][y] + arr[x-1][y+1];
            max = Integer.max(max, var);
        }

        // 좌측 3개
        if (x-1 >= 0 && y-1 >= 0 && x+1 < arr.length) {
            var = arr[x][y] + arr[x-1][y-1] + arr[x][y-1] + arr[x+1][y-1];
            max = Integer.max(max, var);
        }

        // 우측 3개
        if (x-1 >= 0 && y+1 < arr[0].length && x+1 < arr.length) {
            var = arr[x][y] + arr[x-1][y+1] + arr[x][y+1] + arr[x+1][y+1];
            max = Integer.max(max, var);
        }

        // 아래 3개
        if (x+1 < arr.length && y+1 < arr[0].length && y-1 >= 0) {
            var = arr[x][y] + arr[x+1][y-1] + arr[x+1][y] + arr[x+1][y+1];
            max = Integer.max(max, var);
        }
    }
}