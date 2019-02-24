import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];

        sc.nextLine();
        for(int i=0; i<n; i++) {
            String str = sc.nextLine().trim();
            String[] arr = str.split("");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.valueOf(arr[j]);
            }
        }

        int maxSum = 0;

        // MAIN idea == 모든 칸은 가로로 더해지거나 세로로 더해지거나 2가지 경우를 가짐


        // 비트마스크 활용. n x m 의 행렬을 1차원 배열로 나타내고
        // 0은 가로뱡향 합, 1은 세로방향 합으로 진행
        for(int tc=0; tc < (1 << n*m); tc++) {
            String tcStr = String.format("%"+ Integer.toString(m*n) + "s", Integer.toBinaryString(tc)).replace(" ", "0");

            // 가로방향 조각들의 합 구하기
            int rowTotalSum = 0;
            for(int rowIdx=0; rowIdx<n; rowIdx++) {
                int rowSum = 0;
                for(int colIdx=0; colIdx<m; colIdx++) {
                    if(tcStr.charAt(m*rowIdx + colIdx) == '0')
                        rowSum = rowSum * 10 + map[rowIdx][colIdx];
                    else {
                        rowTotalSum += rowSum;
                        rowSum = 0;
                    }
                }
                rowTotalSum += rowSum;
            }

            // 세로방향 조각들의 합 구하기
            int colTotalSum = 0;
            for(int colIdx=0; colIdx<m; colIdx++) {
                int colSum = 0;
                for(int rowIdx=0; rowIdx<n; rowIdx++) {
                    if(tcStr.charAt(m*rowIdx + colIdx) == '1')
                        colSum = colSum * 10 + map[rowIdx][colIdx];
                    else {
                        colTotalSum += colSum;
                        colSum = 0;
                    }
                }
                colTotalSum += colSum;
            }

            // 전체 합
            int sum = rowTotalSum + colTotalSum;
            if(maxSum < sum)
                maxSum = sum;
        }

        System.out.println(maxSum);
    }
}
