import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int [][] map = new int[200002][2]; // 뒤에 -> 인덱스 0 :방문하는데 드는 비용, 인덱스1 : 이전 점

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        map[n][0] = 1; // 방문비용 1로 시작 (출력할 때 1 빼줘야함)
        map[n][1] = -1; // 시작점은 이전 점을 -1로 표시

        while(!q.isEmpty()) {
            int p = q.poll();

            if(p==k)
                break;

            if(p+1 < 200001 && map[p+1][0] == 0) {
                q.offer(p+1);
                map[p+1][0] = map[p][0]+1;
                map[p+1][1] = p;
            }

            if(p-1 >= 0 && map[p-1][0] == 0) {
                q.offer(p-1);
                map[p-1][0] = map[p][0]+1;
                map[p-1][1] = p;
            }

            if(2*p < 200001 && map[2*p][0] == 0) {
                q.offer(2*p);
                map[2*p][0] = map[p][0]+1;
                map[2*p][1] = p;
            }

        }

        // 비용 출력
        System.out.println(map[k][0]-1);

        // 지나온 길 역추적
        int before = k;
        List<Integer> l = new ArrayList<>();
        while(before != -1) {
            l.add(before);
            before = map[before][1];
        }
        
        // 리스트 거꾸로 출력
        for(int i=l.size()-1; i>=0; i--)
            System.out.print(l.get(i) + " ");
    }
}