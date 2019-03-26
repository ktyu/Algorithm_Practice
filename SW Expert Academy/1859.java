// 문제 해석 해서 O(n)으로 간단하게 구현한거
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
                
        int tcCnt = sc.nextInt();
        
        for(int tcNum=1; tcNum<=tcCnt; tcNum++) {
        	int n = sc.nextInt();
        	int[] arr = new int[n];
        	for(int i=0; i<n; i++) {
        		arr[i] = sc.nextInt();
        	}
        	
        	long answer = 0;
        	int max = arr[n-1];
        	for(int i=n-2; i>=0; i--) {
        		if(max >= arr[i]) {
        			answer += (long)(max - arr[i]); // 타입 주의.. 각 매매가는 10000이하지만 N이 백만까지라서 다 더해지다보면 int 범위 초과될 수 있음
        		}
        		else {
        			max = arr[i];
        		}
        	}        	
        	System.out.println("#" + tcNum + " " + answer);
        }
    }
}



// --------------------------------------------------------------------------------------
// 참고로 O(n^2)로 짜면 패스 안됨



// TreeMap 과 Entry 이용해서 구현.. O(nlogn) 이라서 위에 코드에 비하면 옵티멀은 아니지만 pass는 됨
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcnum = sc.nextInt();

        for(int tcidx=1; tcidx<=tcnum; tcidx++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0; i<N; i++) {
               arr[i] = sc.nextInt();
                map.put(arr[i], i);
            }


            long answer = 0;
            Map.Entry<Integer, Integer> max = map.pollLastEntry();
            
            for(int i=0; i<arr.length; i++) {
               // 현재 최대값의 인덱스까지 왔으면 해당 최대값은 삭제하고 max를 다시 얻음
               if(i == max.getValue()) {
                  do {
                     max = map.pollLastEntry();
                  } while(max != null && i >= max.getValue());
                  
                continue;
               }
              answer += max.getKey() - arr[i];               
            }

            System.out.println("#" + tcidx + ' ' + answer);
        }
    }
}
