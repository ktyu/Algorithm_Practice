import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> nodes = new ArrayList<>(n);
        for (int i = 0; i < n + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        int cnt = 0;
        List<Integer> visited = new ArrayList<>();

        while(visited.size() != n) {
            cnt++;

            for(int i=1; i<=n; i++) {
                if(visited.contains(i))
                    continue;
                visited = bfs(nodes, n, i, visited);
                break;
            }
        }

        System.out.println(cnt);
    }


    public static List<Integer> bfs(List nodes, int n, int start, List<Integer> visited) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n+1];
        q.offer(start);

        while (!(q.isEmpty())) {
            int now = q.poll();

            if (check[now])
                continue;

            visited.add(now);
            check[now] = true;

            for (Object num : (List) nodes.get(now)) {
                int next = (int) num;
                q.offer(next);
            }
        }

        return visited;
    }
}
