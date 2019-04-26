import java.util.*;

public class Main {

    static class Pair {
        int num, pri;
        Pair(int num, int pri) {this.num=num; this.pri=pri;}
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcNum = sc.nextInt();

        while(tcNum-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<Pair> q = new LinkedList<>();
            for(int i=0; i<n; i++)
                q.add(new Pair(i, sc.nextInt()));
            
            int order = 0;
            Pair now = null;

            while(true) {
                // 우선순위가 가장 높은 프린터물이 now에 걸릴때까지 반복
                while (now == null) {
                    now = q.remove();
                    for (Pair p : q) {
                        if (p.pri > now.pri) {
                            q.add(now);
                            now = null;
                            break;
                        }
                    }
                }

                // 찾아야할 순서의 프린트물이면 정지
                order++;
                if(now.num == m) {
                    System.out.println(order);
                    break;
                }
                else
                    now = null;
                
            }

        }
    }
}