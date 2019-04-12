import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 세로선의 개수 = 세로 초록선의 개수
		m = sc.nextInt(); // 이미 존재하는 가로선의 개수
		h = sc.nextInt(); // 가로선을 놓을 수 있는 위치의 개수? == 가로점선의 개수
		
		arr = new boolean[h+1][n+1];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); // 가로점선 번호
			int b = sc.nextInt(); // 세로선    번호 (b와 b+1 번을 연결)
			
			arr[a][b] = true;
		}
		
		int answer = -1;

		// 지금 상태에서 검사
		if(check())
			answer = 0;
		
		
		// 1개 추가해서 가능한지 검사
		if(answer == -1) {
			for(int i=1; i<=h; i++) {
				for(int j=1; j<=n-1; j++) {
					// 이미 있는 사다리의 경우 스킵
					if(arr[i][j])
						continue;
					
					// 사다리가 연속으로 놔지는 경우 스킵
					if((j-1 >=0 && arr[i][j-1]) || (j<n && arr[i][j+1]))
						continue;
					
					// 사다리 1개 추가해서 검사
					arr[i][j] = true;
					if(check())
						answer = 1;
					arr[i][j] = false;
				}
			}
		}
		
		
		// 2개 추가해서 가능한지 검사
		if(answer == -1) {
			for(int i=1; i<=h; i++) {
				for(int ii=1; ii<=h; ii++) {
					for(int j=1; j<=n-1; j++) {
						for(int jj=1; jj<=n-1; jj++) {
							
							// 고른 2개의 사다리가 같을 경우 스킵
							if(i==ii && j==jj)
								continue;
							
							// 고른 2개의 사다리가 붙어있을 경우 스킵
							if(i==ii && Math.abs(j-jj) == 1)
								continue;
							
							// 이미 있는 사다리의 경우 스킵
							if(arr[i][j] || arr[ii][jj])
								continue;
							
							// 사다리가 연속으로 놔지는 경우 스킵
							if((j-1 >=0 && arr[i][j-1]) || (j<n && arr[i][j+1]))
								continue;
							if((jj-1 >=0 && arr[ii][jj-1]) || (jj<n && arr[ii][jj+1]))
								continue;
							
							// 사다리 2개 추가해서 검사
							arr[i][j] = true;
							arr[ii][jj] = true;
							if(check())
								answer = 2;
							arr[i][j] = false;
							arr[ii][jj] = false;
							
						}
					}
				}
			}
		}
		
		
		
		// 3개 추가해서 가능한지 검사
		if(answer == -1) {
			for(int i=1; i<=h; i++) {
				for(int ii=1; ii<=h; ii++) {
					for(int iii=1; iii<=h; iii++) {
					
						for(int j=1; j<=n-1; j++) {
							for(int jj=1; jj<=n-1; jj++) {
								for(int jjj=1; jjj<=n-1; jjj++) {
									
									// 고른 3개의 사다리중 같은게 있을 경우 스킵
									if((i==ii && j==jj) || (i==iii && j==jjj) || (ii==iii && jj==jjj))
										continue;
									
									// 고른 3개의 사다리중 붙어있는게 있을 경우 스킵
									if( (i==ii && Math.abs(j-jj) == 1) || (i==iii && Math.abs(j-jjj) == 1) || (ii==iii && Math.abs(jj-jjj) == 1))
										continue;
									
									// 이미 있는 사다리가 골라진 경우 스킵
									if(arr[i][j] || arr[ii][jj] || arr[iii][jjj])
										continue;
									
									// 사다리가 연속으로 놔지는 경우 스킵
									if((j-1 >=0 && arr[i][j-1]) || (j<n && arr[i][j+1]))
										continue;
									if((jj-1 >=0 && arr[ii][jj-1]) || (jj<n && arr[ii][jj+1]))
										continue;
									if((jjj-1 >=0 && arr[iii][jjj-1]) || (jjj<n && arr[iii][jjj+1]))
										continue;
									
									// 사다리 3개 추가해서 검사
									arr[i][j] = true;
									arr[ii][jj] = true;
									arr[iii][jjj] = true;
									if(check())
										answer = 3;
									arr[i][j] = false;
									arr[ii][jj] = false;
									arr[iii][jjj] = false;
							
								}
							}
						}
					}
				}
			}
		}
		
		
		System.out.println(answer);
	}
	
	static int n;
	static int m;
	static int h;
	static boolean[][] arr;
	
	// 세로선의 도착지를 리턴
	static int getDest(int colPos) {
		int rowPos = 0;
		
		while(++rowPos < h+1) {
			
			// 좌측으로 가야하는지 확인
			if(colPos > 1 && arr[rowPos][colPos-1]) {
				colPos -= 1;
			}
			// 우측으로 가야하는지 확인
			else if(colPos < n+1 && arr[rowPos][colPos]) {
				colPos += 1;
			}
			
		}
			
		return colPos;
	}
	
	static boolean check() {
		for(int i=1; i<=n; i++) {
			if(getDest(i) != i) {
				return false;
			}
		}
		
		return true;
	}
	
}