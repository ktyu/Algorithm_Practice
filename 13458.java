import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int roomCnt = sc.nextInt();
        int[] rooms = new int[roomCnt];
        
        for(int i=0; i<roomCnt; i++) {
        	rooms[i] = sc.nextInt();
        }
        
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        long answer = roomCnt;
        for(int i=0; i<roomCnt; i++) {
            if(rooms[i]-B <= 0)
        		continue;
            
        	answer += (long)Math.ceil((rooms[i]-B) / (C*1.0));
        }
        
        System.out.println(answer);
    }
}