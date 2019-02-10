import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcCnt = sc.nextInt();

        for (int tc = 0; tc < tcCnt; tc++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> nodes = new ArrayList<>(n+1);
            for (int i = 0; i < n + 1; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodes.get(a).add(b);
                nodes.get(b).add(a);
            }

            int[] check = new int[nodes.size()];

            boolean isBip = true;
            for(int i=1; isBip && i<nodes.size(); i++) {
                if(check[i] == 0)
                    isBip = bfs(nodes, i, check);
            }

            System.out.println(isBip ? "YES" : "NO");
        }
    }

    public static boolean bfs(List nodes, int start, int[] check) {

        Queue<Integer> q = new LinkedList<>(); // 방문해야할 노드들

        q.offer(start); // 시작점 추가
        check[start] = 1; // 시작점은 A그룹

        while(!(q.isEmpty())) {
            int now = q.poll();

            // 현재 노드에서 갈 수 있는 모든 정점에 대해 수행
            for(Object obj : (List)nodes.get(now)) {
                int num = (int)obj;

                // 아직 방문 안한곳이라면
                if(check[num] == 0) {
                    check[num] = check[now]==1 ? 2 : 1; // 색깔부여
                    q.offer(num); // 큐에 추가
                }

                // 이미 갔다온곳이면
                else {
                    if((check[now] != check[num])) // 색깔 다르면 넘어가기
                        continue;
                    return false; // 색깔 틀리면 false 리턴
                }
            }
        }

        return true; // 다 잘 순회했으면 true 리턴
    }
}
