import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] map = new int[200002];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        map[n] = 1;

        int minCost = Integer.MAX_VALUE;
        int cnt = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            // 다음 노드 방문비용이 찾아둔 최소비용을 넘어간다면 그만 끝내기
            if(map[now] + 1 > minCost)
                break;

            // 최소비용을 찾은 경우 최초면 기록도 함
            if(now == k) {
                cnt++;
                if(map[k] == 0)
                    minCost = map[now];
                continue;
            }

            // 방문가능한 곳이고, 아직 방문을 안했거나 더 낮거나 같은 비용으로 방문할 수 있으면 방문
            if(now+1 < 200002 && (map[now+1] == 0 || (map[now+1] != 0 && map[now]+1 <= map[now+1]))) {
                map[now+1] = map[now] + 1;
                q.offer(now+1);
            }

            if(now-1 >= 0 && (map[now-1] == 0 || (map[now-1] != 0 && map[now]+1 <= map[now-1]))) {
                map[now-1] = map[now] + 1;
                q.offer(now-1);
            }

            if(now*2 < 200002 && (map[now*2] == 0 || (map[now*2] != 0 && map[now]+1 <= map[now*2]))) {
                map[now*2] = map[now] + 1;
                q.offer(now*2);
            }
        }

        System.out.println(map[k]-1);
        System.out.println(cnt);
    }
}
