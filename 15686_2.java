import java.util.*;

public class Main {

    static class Point {
        int x,y;
        Point(int x, int y) {this.x=x; this.y=y;}

        static int distance(Point a, Point b) {
            return (Math.abs(a.x-b.x) + Math.abs(a.y-b.y));
        }
    }

    static int N;
    static int M;
    static ArrayList<Point> chickens;
    static boolean[] check;

    static ArrayList<Point> homes;
    static ArrayList<ArrayList<Integer>> home_to_chicken;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        home_to_chicken = new ArrayList<>();


        // 입력받기
        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                int num = sc.nextInt();
                if(num == 1) {
                    homes.add(new Point(x, y));
                    home_to_chicken.add(new ArrayList<>());
                }

                else if(num == 2) {
                    chickens.add(new Point(x, y));
                }
            }
        }

        // 각 집에서 각 치킨집까지의 거리 계산해서 저장
        for(int i=0; i<homes.size(); i++) {
            Point h = homes.get(i);
            ArrayList<Integer> distance = home_to_chicken.get(i);

            for(int j=0; j<chickens.size(); j++) {
                Point c = chickens.get(j);
                distance.add(Point.distance(h, c));
            }
        }

        
        check = new boolean[chickens.size()]; // 살릴 치킨집 중복선택 못하게 마킹할 변수
        dfs(new int[M], 0, 0);

        System.out.println(answer);
    }

    // DFS 원리로 재귀호출하는 함수
    
    // 함수의 개요는 sel 배열의 sel_idx 번째에 들어 갈 원소를 반복문안에서 재귀호출하며 다 넣어보는것.
    // 
    public static void dfs(int[] sel, int sel_idx, int arr_idx) {
        // 조합의 후보자를 다 선택한 경우
        if(sel_idx == M) {
            int sum = 0;

            // 각 집에서 선택된 치킨집까지의 거리 중 최소를 구해서 sum에 더함
            for(List distance : home_to_chicken) {
                int min = Integer.MAX_VALUE;
                for(int idx : sel)
                    min = Integer.min(min, (Integer)distance.get(idx));

                sum += min;
            }

            answer = Integer.min(answer, sum);
            return; // 리턴 까먹으면 안됨...
        }


        // 2차원 맵에서는 dx,dy를 돌겠지만 여기선 1차원 배열의 모든 원소가 뽑힐 수 있는 후보군임
        // 조합이므로 자기보다 앞에 있는건 볼 필요 없으므로 arr_idx 변수써서 뒤에꺼부터 보게함
        for(int i=arr_idx; i<chickens.size(); i++) {
            if(check[i]) // 중복 선택 방지
                continue;

            sel[sel_idx] = i; // sel_idx 번째에 i(반복문인덱스) 번째의 후보자를 넣어줌
            
            check[i] = true; // 해당 후보자는 중복사용 x  <<- 이거 중요!!
            dfs(sel, sel_idx+1, i+1); // 다음 sel_idx+1 번째에 넣을걸 지정하기 위해 재귀호출, 순서가 상관없는 조합이므로 현재꺼보다 뒤에꺼만 보면 됨
            check[i] = false; // 다른 Case에선 다시 후보가 될 수 있으므로 false로 원복
        }

    }

}