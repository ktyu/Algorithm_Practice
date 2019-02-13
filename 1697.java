import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] map = new int[200002];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()) {

            // 현재 위치와 지금까지 걸린 시간
            int now = q.poll();
            int sec = map[now];

            // 도착했으면 끝
            if(now == k) {
                System.out.println(sec);
                break;
            }

            // 갈 수 있는 곳에 아직 방문하지 않았으면 가기
            if(now+1 >= 0 && now+1 < 200002 && map[now+1] == 0) {
                map[now+1] = sec + 1;
                q.offer(now + 1);
            }

            if(now-1 >= 0 && now-1 < 200002 && map[now-1] == 0) {
                map[now - 1] = sec + 1;
                q.offer(now - 1);
            }

            if(now*2 >= 0 && now*2 < 200002 && map[now*2] == 0) {
                map[now * 2] = sec + 1;
                q.offer(now * 2);
            }
        }
    }
}
