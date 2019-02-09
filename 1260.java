import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        List<List<Integer>> nodes = new ArrayList<>(n);
        for(int i=0; i<n+1; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        for(List list : nodes)
            Collections.sort(list);

        dfs(nodes, v);
        System.out.println();
        Arrays.fill(check, false);
        bfs(nodes, v);
    }

    static boolean[] check = new boolean[1001];

    public static void dfs(List nodes, int now) {
        // 이미 방문한 곳 이면 끝
        if(check[now])
            return;

        else {
            System.out.printf("%d ", now);
            check[now] = true;
        }

        // 다음 방문
        for(Object next : (List)nodes.get(now))
            dfs(nodes, (int)next);

    }

    public static void bfs(List nodes, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!(q.isEmpty())) {
            int now = q.poll();

            if(check[now])
                continue;

            System.out.printf("%d ", now);
            check[now] = true;

            for(Object num : (List)nodes.get(now)) {
                int next = (int)num;
                q.offer(next);
            }
        }

    }
}
