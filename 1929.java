import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int primeCnt = 0;
        boolean[] arr = new boolean[n+1]; // false == 지워지지 않음, true == 지워짐

        for(int i=2; i<=n; i++) {
            if(!(arr[i])) { // 지워지지 않았으면
                primeCnt++;
                if(i>=m)
                    System.out.println(i);

                for(int j=i*2; j<=n; j+=i) { // j=i*i 로 초기화해도 되지만 n^2이 int 범위를 넘어갈 수 있으므로 2i로 초기화
                    arr[j] = true; // 같은 수가 여러번 true로 지정됨에 주의
                }
            }
        }
    }
}
