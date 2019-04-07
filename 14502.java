package org.sopt;


import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x,y;
        Point(int x, int y) {this.x=x; this.y=y;}
    }

    static int n,m;
    static int[][] map;
    static ArrayList<Point> empty;
    static ArrayList<Point> virus;
    static int answer = 0;

    static Point[] select;
//	static boolean[] check;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine().trim();
        n = Integer.valueOf(str.charAt(0) - '0');
        m = Integer.valueOf(str.charAt(2) - '0');
        map = new int[n][m];
        empty = new ArrayList<>();
        virus = new ArrayList<>(3);

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val == 0)
                    empty.add(new Point(i, j));
                else if(val == 2)
                    virus.add(new Point(i, j));
            }
        }

        select = new Point[3];
//		check = new boolean[empty.size()];
        recursive(0, 0);


        System.out.println(answer);
    }

    static int bfs(int[][] map_old, Point[] select) {
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++)
            map[i] = Arrays.copyOf(map_old[i], m);

        for(Point p : select) {
            map[p.x][p.y] = 1;
        }

        Queue<Point> q = new LinkedList<>();
        for(Point v : virus) {
            q.add(new Point(v.x, v.y));
        }

        while(!q.isEmpty()) {
            Point p = q.remove();

            for(int i=0; i<4; i++) {
                int x = p.x+dx[i];
                int y = p.y+dy[i];

                if(x<0 || x>=n || y<0 || y>=m || map[x][y] != 0)
                    continue;

                map[x][y] = 2;
                q.add(new Point(x, y));
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j] == 0)
                    cnt++;
        return cnt;
    }

    static void recursive(int sel_idx, int list_idx) {
        if(sel_idx == 3) {
            answer = Integer.max(answer, bfs(map, select));
            return;
        }

		/*
		 for(int i=list_idx; i<empty.size(); i++) {
			if(check[i])
				continue;

			select[sel_idx] = empty.get(i);
			check[i] = true;
			recursive(sel_idx+1, list_idx+1);
			check[i] = false;
		}


		 이렇게 check 배열을 만들어서 조합을 찾는것보다
		 아래에 재귀 2문장으로 도는게 두배이상 빠름.. 왜지
		 */

        if(list_idx == empty.size())
            return;

        select[sel_idx] = empty.get(list_idx);
        recursive(sel_idx+1, list_idx+1);
        recursive(sel_idx, list_idx+1);

    }
}