import java.util.*;

public class Main {
	
	static class Dice {
		int x,y;
		int front, rear, left, right, up, down;
		
		Dice(int x, int y) {this.x=x; this.y=y;
		front = rear = left = right = up = down = 0;}
	}
	
	
	static int[][] map;
	static Dice d;
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();

		int k = sc.nextInt();
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] move = new int[k];
		for(int i=0; i<k; i++) {
			move[i] = sc.nextInt();
		}
		
		d = new Dice(x, y);
		for(int num : move) {
			if(num == 1 && d.y+1 < m) {
				right();
				System.out.println(d.up);
			}
			
			else if(num == 2 && d.y-1 >= 0) {
				left();
				System.out.println(d.up);
			}
			
			else if(num == 3 && d.x-1 >= 0) {
				up();
				System.out.println(d.up);
			}
			
			else if(num == 4 && d.x+1 < n) {
				down();
				System.out.println(d.up);
			}
			
		}
	}
	
	static void check() {
		if(map[d.x][d.y] == 0) {
			map[d.x][d.y] = d.down;
		} else {
			d.down = map[d.x][d.y];
			map[d.x][d.y] = 0;
		}
	}
	
	static void right() {
		int temp = d.down;
		
		d.down = d.right;
		d.right = d.up;
		d.up = d.left;
		d.left = temp;
		
		d.y++;
		check();
	}
	
	static void left() {
		int temp = d.down;
		
		d.down = d.left;
		d.left = d.up;
		d.up = d.right;
		d.right= temp;
		
		d.y--;
		check();
	}
	
	static void up() {
		int temp = d.up;
		
		d.up = d.front;
		d.front = d.down;
		d.down = d.rear;
		d.rear = temp;
		
		d.x--;
		check();
	}
	
	static void down() {
		int temp = d.down;
		
		d.down = d.front;
		d.front = d.up;
		d.up = d.rear;
		d.rear = temp;
		
		d.x++;
		check();
	}
}