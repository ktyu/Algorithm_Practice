import java.util.*;

public class Main {
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		int[][] map = new int[n][n];
		boolean[][] used = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		
		// row check
		for(int i=0; i<n; i++) {
			boolean possible = true;
			
			int j = 0;
			while(possible && j+1 < n) {
				
				if(map[i][j] == map[i][j+1]) {
					j++;
				}
				

				else if(map[i][j] > map[i][j+1]) {
					possible = false;
					
					// j+1부터 (포함) l개가 아직 경사로를 안썼고, 크기가 1 작아야함
					int k=0;
					while(k!=l && j+1+k<n && !used[i][j+1+k] && map[i][j]-1 == map[i][j+1+k]) {
						used[i][j+1+k] = true;
						k++;
					}
					
					if(k == l && j+l < n) {
						j += l;
						possible = true;
					}
				}
				
				else if(map[i][j] < map[i][j+1]) {
					possible = false;
					
					// j부터 (포함) 뒤로 l개가 아직 경사로를 안썼고, 크기가 1 작아야함
					int k=0;
					while(k!=l && j-k>=0 && !used[i][j-k] && map[i][j-k]+1 == map[i][j+1]) {
						used[i][j-k] = true;
						k++;
					}
					
					if(k == l && j+1 < n) {
						j++;
						possible = true;
					}
				}
			}
			
			if(possible)
				answer++;
		}
		
		
		
		
		
		// col check
		used = new boolean[n][n];
		
		for(int j=0; j<n; j++) {
			boolean possible = true;
			
			int i = 0;
			while(possible && i+1 < n) {
				
				if(map[i][j] == map[i+1][j]) {
					i++;
				}
				

				else if(map[i][j] > map[i+1][j]) {
					possible = false;
					
					// i+1부터 (포함) l개가 아직 경사로를 안썼고, 크기가 1 작아야함
					int k=0;
					while(k!=l && i+1+k<n && !used[i+1+k][j] && map[i][j]-1 == map[i+1+k][j]) {
						used[i+1+k][j] = true;
						k++;
					}
					
					if(k == l && i+l < n) {
						i += l;
						possible = true;
					}
				}
				
				else if(map[i][j] < map[i+1][j]) {
					possible = false;
					
					// i부터 (포함) 뒤로 l개가 아직 경사로를 안썼고, 크기가 1 작아야함
					int k=0;
					while(k!=l && i-k>=0 && !used[i-k][j] && map[i-k][j]+1 == map[i+1][j]) {
						used[i-k][j] = true;
						k++;
					}
					
					if(k == l && i+1 < n) {
						i++;
						possible = true;
					}
				}
			}
			
			if(possible)
				answer++;
		}
		
		System.out.println(answer);
	}
}