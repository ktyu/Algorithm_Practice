import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            String[] nums = sc.nextLine().trim().split("");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.valueOf(nums[j]);
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        List<Integer> arr = new LinkedList<>();

        Queue<Route> q = new LinkedList<>();
        q.offer(new Route(0,0, 1, new boolean[n][m]));

        int x,y;
        while(!(q.isEmpty())) {
            Route r = q.poll();

            if(r.x == n-1 && r.y == m-1) {
                arr.add(r.cost);
                continue;
            }

            for(int i=0; i<4; i++) {
                x = r.x + dx[i];
                y = r.y + dy[i];

                if(x>=0 && x<n && y>=0 && y<m && map[x][y] == 1 && !(r.visited[x][y])) {
                    boolean[][] visited = Arrays.copyOf(r.visited, n);
                    visited[x][y] = true;
                    q.offer(new Route(x, y, r.cost+1, visited));
                }
            }
        }

        Collections.sort(arr);
        System.out.println(arr.get(0));
    }

}

class Route {
    int x;
    int y;
    int cost;
    boolean[][] visited;

    public Route(int x, int y, int cost, boolean[][] visited) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.visited = visited;

        visited[x][y] = true;
    }
}
