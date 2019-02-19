import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // 가진 사탕의 수
        int n = sc.nextInt(); // 친구 수

        int[] arr = new int[n]; // 각자가 받고 싶은 사탕 개수
        long sum = -1*(long)m; // 줄 수 없는 사탕 개수들의 합

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            sum += (long)arr[i];
        }

        // MAIN Point -> 숫자들의 합과 개수가 같을 때에는 숫자들이 서로 비슷해야 제곱의 합이 작아짐
        //            -> ex) 4^2 + 4^2 (32)< 1^2 + 7^2 (50)
        //    전략     -> 못준 사탕의 개수들의 합을 인원수에 맞게 균일하게 나눔

        long answer = 0; // 제곱의 합을 더할 변수
                         // (2^64로 나눈다는건 ~(1 << 64)와 & 연산을 하는것과 동일하므로 long 타입을 쓰고 신경안써도 되는 조건임)

        Arrays.sort(arr); // 큰 수가 조금이라도 더 받아야하므로 뒤쪽에서 처리되어야함

        for(int i=0; i<n; i++) {
            long fair = sum / (n-i); // 아직 못준 개수를 인원수만큼 균등하게 분배 (그리디 알고리즘 == 현재 순간의 최적해를 선택)

            long val = Math.min((long)arr[i], fair); // 받아야할 개수가 균등분배의 양보다 적으면, 하나도 주지 않음

            answer += val*val; // i번째 친구에게 못준 개수의 제곱

            sum -= val; // i번째 친구에게 못준 사탕의 개수 제거
        }

        System.out.println(answer);
    }
}