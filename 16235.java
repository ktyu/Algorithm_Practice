import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		
		Tree(int x, int y, int age) {this.x=x; this.y=y; this.age=age;}

		@Override
		public int compareTo(Tree o) {
			if(this.age > o.age)
				return 1;
			else if(this.age < o.age)
				return -1;
			else
				return 0;
		}		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] eatable = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				eatable[i][j] = 5;
		
		
		int[][] gain = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				gain[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Tree> alive = new ArrayList<>(m);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			alive.add(new Tree(x-1, y-1, age));
		}
		Collections.sort(alive);
		
		
		ArrayList<Tree> dead;
		while(k-- > 0) {
			dead = new ArrayList<>();
			ArrayList<Tree> alive_new = new ArrayList<>();

			// 봄
			for(Tree t : alive) {
				if(t.age <= eatable[t.x][t.y]) {
					eatable[t.x][t.y] -= t.age;
					t.age++;
					alive_new.add(t);
				} else {
					dead.add(t);
				}
			}
			
			// 여름
			for(Tree t : dead) {
				eatable[t.x][t.y] += t.age/2;
			}
			
			// 가을
			ArrayList<Tree> born = new ArrayList<>();
			for(Tree t : alive_new) {
				if(t.age%5 == 0) {
					for(int i=0; i<8; i++) {
						int x = t.x+dx[i];
						int y = t.y+dy[i];
						
						if(x<0 || x>=n || y<0 || y>=n)
							continue;
						
						born.add(new Tree(x, y, 1));
					}
				}
			}
			born.addAll(alive_new);
			alive = born;
			
			// 겨울
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					eatable[i][j] += gain[i][j];
				}
			}
		}
		
		System.out.println(alive.size());
	}
	
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
	static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
}