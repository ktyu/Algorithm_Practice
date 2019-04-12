import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		// 무조건 0에서 출발한다고 생각하고 1부터 끝까지 순회하면됨
		check = new boolean[n];
		check[0] = true;
		go(arr, 1, 0, 0);
		
		
		System.out.println(answer);
	}
	
	static long answer = Long.MAX_VALUE;
	static boolean[] check;
	
	
	public static void go(int[][] arr, int cnt, int current, long sum) {
		if(cnt == arr.length) {
			if(arr[current][0] == 0)
				return;
			
			answer = Long.min(answer, sum+arr[current][0]);
			return;
		}
		
		
		for(int i=1; i<arr.length; i++) {
			if(check[i] || arr[current][i] == 0)
				continue;
			
			check[i] = true;
			go(arr, cnt+1, i, sum+arr[current][i]);
			check[i] = false;
		}
	}
}