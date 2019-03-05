import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                map[i][j] = sc.nextInt();

        // 00=상, 01=하, 10=좌, 11=우
        for(int i=(1<<10)-1; i>=0; i--) {
            int mask = i;
            int[][] thisMap = map.clone();

            // 최대 5회까지 이동가능
            for(int s=0; s<5; s++, mask >>=2) {
                int flag = mask & 3;

                if(flag == 0)
                    thisMap = moveUp(thisMap);
                else if(flag == 1)
                    thisMap = moveDown(thisMap);
                else if(flag == 2)
                    thisMap = moveLeft(thisMap);
                else if(flag == 3)
                    thisMap = moveRight(thisMap);
                else
                    System.exit(-1);
            }
        }

        System.out.println(max);

    }

    public static int max = 0;

    public static int[][] moveUp(int[][] map) {
        int n = map.length;
        int[][] movedMap = new int[n][n];

        for(int c=0; c<n; c++){
            int[] tempCol = new int[n];
            int i = 0;
            boolean merged = false;

            for(int r=0; r<n; r++) {
                if(map[r][c] == 0)
                    continue;
                if(i>0 && tempCol[i-1] == map[r][c] && !(merged)) {
                    tempCol[i-1] *= 2;
                    max = Math.max(max, tempCol[i-1]);
                    merged = true;
                }
                else {
                    tempCol[i] = map[r][c];
                    max = Math.max(max, tempCol[i++]);
                    merged = false;
                }
            }

            for(int r=0; r<n; r++)
                movedMap[r][c] = tempCol[r];
        }

        return movedMap;
    }

    public static int[][] moveDown(int[][] map) {
        int n = map.length;
        int[][] movedMap = new int[n][n];

        for(int c=0; c<n; c++){
            int[] tempCol = new int[n];
            int i = n-1;
            boolean merged = false;

            for(int r=n-1; r>=0; r--) {
                if(map[r][c] == 0)
                    continue;
                if(i<n-1 && tempCol[i+1] == map[r][c] && !(merged)) {
                    tempCol[i+1] *= 2;
                    max = Math.max(max, tempCol[i+1]);
                    merged = true;
                }
                else {
                    tempCol[i] = map[r][c];
                    max = Math.max(max, tempCol[i--]);
                    merged = false;
                }
            }

            for(int r=0; r<n; r++)
                movedMap[r][c] = tempCol[r];
        }

        return movedMap;
    }

    public static int[][] moveLeft(int[][] map) {
        int n = map.length;
        int[][] movedMap = new int[n][n];

        for(int r=0; r<n; r++) {
            int[] tempRow = new int[n];
            int i = 0;
            boolean merged = false;

            for(int c=0; c<n; c++) {
                if(map[r][c] == 0)
                    continue;
                if(i>0 && tempRow[i-1] == map[r][c] && !(merged)) {
                    tempRow[i-1] *= 2;
                    merged = true;
                    max = Math.max(max, tempRow[i-1]);
                }
                else {
                    tempRow[i] = map[r][c];
                    merged = false;
                    max = Math.max(max, tempRow[i++]);
                }
            }

            movedMap[r] = tempRow;
        }

        return movedMap;
    }


    public static int[][] moveRight(int[][] map) {
        int n = map.length;
        int[][] movedMap = new int[n][n];

        for(int r=0 ; r<n; r++) {
            int[] tempRow = new int[n];
            int i = n-1;
            boolean merged = false;

            for(int c=n-1; c>=0; c--) {
                if(map[r][c] == 0)
                    continue;
                if(i<n-1 && tempRow[i+1] == map[r][c] && !(merged)) {
                    tempRow[i+1] *= 2;
                    max = Math.max(max, tempRow[i+1]);
                    merged = true;
                }
                else {
                    tempRow[i] = map[r][c];
                    max = Math.max(max, tempRow[i--]);
                    merged = false;
                }
            }

            movedMap[r] = tempRow;
        }

        return movedMap;
    }
}