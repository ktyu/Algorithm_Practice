import java.util.*;

public class Main {

    static class Case {
        int[][] map;
        int empty_x, empty_y;

//        ArrayList<Character> route = new ArrayList<>();
        int movedCnt = 0;

        Case(int[][] map, int x, int y) {
            this.map = map;
            this.empty_x = x;
            this.empty_y = y;
        }

        Case() {}

        @Override
        public Case clone() {
            Case c = new Case();

            int[][] copiedMap = new int[SIZE][SIZE];
            for(int i=0; i<SIZE; i++) {
                for(int j=0; j<SIZE; j++) {
                    copiedMap[i][j] = this.map[i][j];
                }
            }
            c.map = copiedMap;

            c.empty_x = this.empty_x;
            c.empty_y = this.empty_y;

//            c.route = (ArrayList<Character>)this.route.clone();
            c.movedCnt = this.movedCnt;

            return c;
        }
    }

    static int SIZE = 3; // 5
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcCnt = 1; // sc.nextInt();
        for(int tcNum=1; tcNum<=tcCnt; tcNum++) {
            int[][] map = new int[SIZE][SIZE];
            int init_x=-1, init_y=-1;

            for(int i=0; i<SIZE; i++) {
                for(int j=0; j<SIZE; j++) {
                    int num = sc.nextInt();
                    if(num == 0)//SIZE*SIZE)
                    { num=9; init_x = i; init_y = j; }
                    map[i][j] = num;
                }
            }

            Queue<Case> q = new LinkedList<>();

            Case init = new Case(map, init_x, init_y);
            q.add(init);

            HashMap<String, Integer> visited = new HashMap<>();
            visited.put(myToString(map), 0);

            Case answer = null;

            while(!q.isEmpty()) {
                Case c = q.remove();

                if(isAnswer(c)) {
                    answer = c;
                    break;
                }

                for(int i=0; i<4; i++) {
                    int x = c.empty_x + dx[i];
                    int y = c.empty_y + dy[i];

                    // 접근 불가
                    if(x<0 || x>=SIZE || y<0 || y>=SIZE)
                        continue;

                    Case next = c.clone();

                    // map swap
                    int tmp = next.map[x][y];
                    next.map[x][y] = SIZE*SIZE;
                    next.map[c.empty_x][c.empty_y] = tmp;

                    // add route
                    char ch = ' ';
                    switch(i) {
                        case 0:
                            ch = 'D';
                            break;

                        case 1:
                            ch = 'R';
                            break;

                        case 2:
                            ch = 'U';
                            break;

                        case 3:
                            ch = 'L';
                            break;
                    }
//                    next.route.add(ch);

                    // cnt plus
                    next.movedCnt++;

                    // set emtpy point
                    next.empty_x = x;
                    next.empty_y = y;


                    // 이미 확인한 Case
                    if(visited.containsKey(myToString(next.map)))
                        continue;

                    q.add(next);
                    visited.put(myToString(next.map), next.movedCnt);
                }
            }

            if(answer == null)
//                System.out.println("#" + tcNum + " -1");
                System.out.println(-1);
            else
//                System.out.println("#" + tcNum + " " + answer.movedCnt + " " + answer.route.toString());
                System.out.println(answer.movedCnt);
        }

    }

    static String myToString(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                sb.append(map[i][j]);
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    static boolean isAnswer(Case c) {
        int num = 0;

        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                if(c.map[i][j] != ++num)
                    return false;
            }
        }

        return true;
    }
}