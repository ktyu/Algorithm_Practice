import java.util.*;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {this.x=x; this.y=y;}

        static int getDistance(Point start, Point end) {
            return Math.abs(start.x-end.x) + Math.abs(start.y-end.y);
        }

        static boolean checkReachable(Point start, Point end, int beer) {
            if(getDistance(start, end) <= beer*50)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcCnt = sc.nextInt();

        while(tcCnt-- > 0) {

            int storeCnt = sc.nextInt();

            Point start = new Point(sc.nextInt(), sc.nextInt());

            Point[] stores = new Point[storeCnt];
            for(int i=0; i<storeCnt; i++) {
                stores[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            Point end = new Point(sc.nextInt(), sc.nextInt());

            answer = false;
            check = new boolean[storeCnt];
            recursive(stores, end, start, 20);
            System.out.println(answer ? "happy" : "sad");
            answer = false;
        }
    }

    static boolean answer;
    static boolean[] check;

    public static void recursive(Point[] stores, Point goal, Point current, int beer) {
        if(Point.checkReachable(current, goal, beer)) {
            answer = true;
            return;
        }

        for(int i=0; i<stores.length; i++) {
            if(check[i] || !Point.checkReachable(current, stores[i], beer))
                continue;
            check[i] = true;
            recursive(stores, goal, stores[i], beer);
//            check[i] = false; // 이걸 추가하면 중복방문을 하기때문에 시간초과남. 목적지에 방문가능한지만 찾으면 되므로 중복방문 필요없음
        }
        
    }
}