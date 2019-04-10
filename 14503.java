import java.util.*;

public class Main {
	
	static class Robot {
		int x, y, direction;
		Robot(int x, int y, int direction) {this.x=x; this.y=y; this.direction=direction;}
	}
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Robot r = new Robot(sc.nextInt(), sc.nextInt(), sc.nextInt());
		if(r.direction == 1)
			r.direction = 3;
		else if(r.direction == 3)
			r.direction = 1;
		
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
			
		// 북, 서, 남, 동
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		int cnt = 0;
		boolean end = false;
		
		while(!end) {
			// 청소 실시
			if(map[r.x][r.y] == 0) {
				map[r.x][r.y] = 2;
				cnt++;
			}
			
			// 순서대로 검사해서 갈 수 있는 곳 발견되면 이동
			boolean foundToGo = false;
			for(int i=1; i<5; i++) {
				int direction = (r.direction + i) % 4;
				int x = r.x+dx[direction];
				int y = r.y+dy[direction];
				
				// 빈칸이면 이동
				if(map[x][y] == 0) {
					r.x=x;
					r.y=y;
					r.direction = direction;
					foundToGo = true;
					break;
				}
			}
			
			// 4방향 모두 갈 수 없었다면
			if(!foundToGo) {
				int rear = (r.direction+2) % 4;
				int x = r.x+dx[rear];
				int y = r.y+dy[rear];
				
				if(map[x][y] == 1) {
					end = true;
				}
				
				else {
					r.x = x;
					r.y = y;
				}
				
			}
			
		}
		
		System.out.println(cnt);
	}
}
