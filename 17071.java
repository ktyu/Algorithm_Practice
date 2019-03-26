import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        // 수빈이 먼저 BFS로 위치 최소비용 기록하기
        // 최소비용을 구하되, 비용이 홀일때/짝일때 구분을 해줘야함!!!!!
        int[][] subin = new int[2][500001];
        
        Arrays.fill(subin[0], -1);
        Arrays.fill(subin[1], -1);
        
        Queue<Integer> q = new LinkedList<>();
    	subin[0][n] = 0;
    	q.add(n);
    	
    	while(!q.isEmpty()) {
    		int pos = q.remove();
    		int evenCost = subin[0][pos];
    		int oddCost = subin[1][pos];
    		
    		if(evenCost != -1) {
	    		if(pos-1 >= 0 && subin[1][pos-1] == -1) {
	    			subin[1][pos-1] = evenCost+1;
	    			q.add(pos-1);
	    		}
	    		
	    		if(pos+1 <= 500000 && subin[1][pos+1] == -1) {
	    			subin[1][pos+1] = evenCost+1;
	    			q.add(pos+1);
	    		}
	    		
	    		if(pos*2 <= 500000 && subin[1][pos*2] == -1) {
	    			subin[1][pos*2] = evenCost+1;
	    			q.add(pos*2);
	    		}
    		}
    		
    		if(oddCost != -1) {
	    		if(pos-1 >= 0 && subin[0][pos-1] == -1) {
	    			subin[0][pos-1] = oddCost+1;
	    			q.add(pos-1);
	    		}
	    		
	    		if(pos+1 <= 500000 && subin[0][pos+1] == -1) {
	    			subin[0][pos+1] = oddCost+1;
	    			q.add(pos+1);
	    		}
	    		
	    		if(pos*2 <= 500000 && subin[0][pos*2] == -1) {
	    			subin[0][pos*2] = oddCost+1;
	    			q.add(pos*2);
	    		}
    		}
    	}
    	
    	int answer = Integer.MAX_VALUE;
    	
    	// 동생 출발, 동생의 위치가 k
    	int time = 0;
    	while(k <= 500000) {
    		// 동시에 도착해서 딱 만나거나, 수빈이가 먼저와서 2씩 더해가며 기다리면 만나는 경우 답
    		if(time >= subin[time%2][k])
    			answer = Integer.min(answer, time);
    		
    		k += ++time;
    	}
    	
    	if(answer == Integer.MAX_VALUE)
    		System.out.println(-1);
    	else
    		System.out.println(answer);
    	
    }
}