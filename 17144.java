import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int r;
    static int c;
    static int t;

    static int cleaner_x = -1;
    static int cleaner_y = -1;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());


        int[][] map = new int[r][c];
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<c; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;

                if(input == -1 && cleaner_x == -1) {
                    cleaner_x = i;
                    cleaner_y = j;
                }
            }
        }

        // t초만큼 진행
        for(int i=0; i<t; i++) {
            map = spread(map);
            rolling(map);
        }

        // 합 구하기
        int answer = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                answer += map[i][j];
            }
        }

        System.out.println(answer+2); // -1 2개 처리

    }

    public static int[][] spread(int[][] before) {
        int[][] after = new int[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {

                // 확산할 필요가 없는 칸이면 skip
                if(before[i][j] == 0) {
                    continue;
                }

                if(before[i][j] == -1) {
                    after[i][j] = -1;
                    continue;
                }

                int val = before[i][j] / 5;
                int cnt = 0;

                // 상하좌우에 확산될 값 더해줌
                for(int a=0; a<4; a++) {
                    int x = i+dx[a];
                    int y = j+dy[a];

                    if(x<0 || x>=r || y<0 || y>=c || before[x][y] == -1)
                        continue;

                    after[x][y] += val;
                    cnt++;
                }

                // 현재 칸에 남아있는 미세먼지 더해줌
                after[i][j] += before[i][j] - (val*cnt);
            }
        }

        return after;
    }

    public static void rolling(int[][] map) {
        int x,y;

        // 위쪽영역 반시계방향
        x = cleaner_x;
        y = cleaner_y;

        while(x-1 >= 0) {
            map[x][y] = map[x-1][y];
            x--;
        }
        map[cleaner_x][cleaner_y] = -1;

        while(y+1 < c) {
            map[x][y] = map[x][y+1];
            y++;
        }

        while(x+1 <= cleaner_x) {
            map[x][y] = map[x+1][y];
            x++;
        }

        while(y-1 >= 0) {
            map[x][y] = map[x][y-1];
            y--;
        }
        map[cleaner_x][cleaner_y+1] = 0;

        // 아래쪽영역 시계방향
        x = cleaner_x+1;
        y = cleaner_y;

        while(x+1 < r) {
            map[x][y] = map[x+1][y];
            x++;
        }
        map[cleaner_x+1][cleaner_y] = -1;

        while(y+1 < c) {
            map[x][y] = map[x][y+1];
            y++;
        }

        while(x-1 >= cleaner_x+1) {
            map[x][y] = map[x-1][y];
            x--;
        }

        while(y-1 >= 0) {
            map[x][y] = map[x][y-1];
            y--;
        }
        map[cleaner_x+1][cleaner_y+1] = 0;
    }
}