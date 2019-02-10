import java.util.*;

// 2/9 작성 (자바)

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] nums = sc.nextLine().split("");
            for(int j=0; j<n; j++) {
                map[j][i] = Integer.valueOf(nums[j]);
            }
        }

        // map의 값이 1이면 단지구분이 안된 아파트, 2부터는 단지번호
        int groupNum = 1;
        List<Integer> list = new ArrayList<>();

        // map의 각 좌표를 다 돌면서 아파트가 존재하면 dfs로 단지 묶어서 번호 부여
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[j][i] == 1) {
                    aptCnt = 0;
                    dfs(map, ++groupNum, j, i);
                    list.add(aptCnt);
                }
            }
        }

        // 단지 개수 출력
        System.out.println(groupNum-1);

        // 정렬해서 각 개수들 출력
        Collections.sort(list);
        for(int num : list) {
            System.out.println(num);
        }
    }

    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};
    public static int aptCnt;

    public static void dfs(int[][]map, int groupNum, int x, int y) {

        // 현재 좌표에 아파트 1개 존재
        map[x][y] = groupNum;
        aptCnt++;

        // 상하좌우 검사
        for(int i=0; i<4; i++) {
            int xx = x+dx[i];
            int yy = y+dy[i];

            if(xx < 0 || xx >= map.length)
                continue;
            if(yy < 0 || yy >= map.length)
                continue;

            if(map[xx][yy] == 1) {
                dfs(map, groupNum, xx, yy);
            }
        }
    }

}
