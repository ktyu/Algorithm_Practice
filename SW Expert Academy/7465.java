import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tcCnt = sc.nextInt();
		int tc = 0;
		
		while(++tc <= tcCnt) {
			int manNum = sc.nextInt();
			int relNum = sc.nextInt();
			
			int[] group = new int[manNum+1];
			int groupNum = 0;
			
			ArrayList<Integer>[] rels = new ArrayList[manNum+1];
			for(int i=1; i<manNum+1; i++) {
				rels[i] = new ArrayList<>();
			}
			
			for(int i=0; i<relNum; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				rels[a].add(b);
				rels[b].add(a);
			}
			
			
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=1; i<=manNum; i++) {
				if(group[i] == 0) {
					group[i] = ++groupNum;
					q.add(i);
					
					while(!q.isEmpty()) {
						int p = q.remove();
						
						for(int friend : rels[p]) {
							
							if(group[friend] != 0)
								continue;
							
							group[friend] = group[p];
							q.add(friend);
						}
					}
				}
			}
			
			System.out.println("#" + (tc) + " " + groupNum);
		}
	}
}