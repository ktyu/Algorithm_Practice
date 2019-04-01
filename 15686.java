import java.util.*;

public class Main {

	static class Point {
		int x,y;
		Point(int x, int y) {this.x=x; this.y=y;}
		
		static int distance(Point a, Point b) {
			return (Math.abs(a.x-b.x) + Math.abs(a.y-b.y));
		}
	}
	
	static int N;
    static int M;
    static ArrayList<Point> chickens; 
    static ArrayList<Point> homes;
    static ArrayList<ArrayList<Integer>> home_to_chicken;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        home_to_chicken = new ArrayList<>();
        
        // 입력받기
        for(int x=0; x<N; x++) {
        	for(int y=0; y<N; y++) {
        		int num = sc.nextInt();
        		if(num == 1) {
        			homes.add(new Point(x, y));
        			home_to_chicken.add(new ArrayList<>());
        		}
        		
        		else if(num == 2) {
        			chickens.add(new Point(x, y));
        		}
        	}
        }
        
        // 각 집에서 각 치킨집까지의 거리 계산해서 저장
        for(int i=0; i<homes.size(); i++) {
        	Point h = homes.get(i);
        	ArrayList<Integer> distance = home_to_chicken.get(i);
        	
        	for(int j=0; j<chickens.size(); j++) {
        		Point c = chickens.get(j);
        		distance.add(Point.distance(h, c));
        	}
        }
        
        
        // next_permu에 쓸 배열 (살릴 치킨집을 1로 마킹)
        int[] live = new int[chickens.size()];
        for(int i=0; i<M; i++) live[chickens.size()-1-i] = 1;

        
        // 치킨집개수 C m 번 만큼 반복
        while(live != null) {
        	int sum = 0;
        
        	// 집마다 반복
        	for(int i=0; i<homes.size(); i++) {

        		// 자기집에서 가장 가까운 치킨거리 찾아 sum에 더하기
        		List<Integer> list = home_to_chicken.get(i);
        		int min = Integer.MAX_VALUE;
        		
        		for(int j=0; j<list.size(); j++) {
        			if(live[j] == 0)
        				continue;
        			min = Integer.min(min, list.get(j));
        		}
        		
        		sum += min;
        	}
        		
        	answer = Integer.min(answer, sum);
        	live = next_permu(live);
        }
        
        System.out.println(answer);
    }
    
    public static int[] next_permu(int[] arr_origin) {
    	int[] arr = arr_origin.clone();
    	
    	// 뒤에서부터 볼 때 오름차순이 깨지기 전 마지막 인덱스 i 찾기
    	int i = arr.length-1;
    	while(i>0 && arr[i-1] >= arr[i]) i--;
    	if(i==0) return null;
    	
    	// 뒤에서부터 arr[i-1]보다 큰 수중에 제일 작은거 찾기
    	// -> (뒤에서부터 오름차순이므로 arr[i-1]보다 작거나 같은 경우에만 계속 진행)
    	int j = arr.length-1;
    	while(arr[i-1] >= arr[j]) j--;
    	
    	// i-1과 j 바꾸기
    	int temp = arr[j];
    	arr[j] = arr[i-1];
    	arr[i-1] = temp;
    	
    	// i번째 ~ 맨끝까지 뒤집어주기 (반으로 나눠서 swap하면됨)
    	j = arr.length-1;
    	while(i<j) {
    		temp = arr[i];
    		arr[i] = arr[j];
    		arr[j] = temp;
    		i++; j--;
    	}
    	
    	return arr;
    }
}