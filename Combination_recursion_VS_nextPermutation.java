/*

Test Data & Result

100
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6
2 -5 2 3 -4 7 -4 0 1 -6

----------------------------------------------------

8370
recursive: 6ms
8370
next_permu_Function: 49ms


*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = 3;

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        start_time = System.currentTimeMillis();
        answer = 0;
        int[] selected = new int[M];
        combi(arr, selected, 0, 0);
        end_time = System.currentTimeMillis();
        System.out.println(answer);
        System.out.println("recursive: " + (end_time-start_time) + "ms");


        start_time = System.currentTimeMillis();
        answer = 0;
        int[] bitmask = new int[N];
        bitmask[N-1] = 1;
        bitmask[N-2] = 1;
        bitmask[N-3] = 1;
        while(bitmask != null) {
            int sum = 0;
            for(int i=0; i<N; i++) {
                if(bitmask[i] == 0)
                    continue;
                sum += arr[i];
            }
            if(sum==0) answer++;

            bitmask = next_permu(bitmask);
        }
        end_time = System.currentTimeMillis();
        System.out.println(answer);
        System.out.println("next_permu_Function: " + (end_time-start_time) + "ms");

    }

    static int answer = 0;
    static long start_time;
    static long end_time;

    static void combi(int[] arr, int[] selected, int selected_idx, int options_idx) {
        if(selected_idx == selected.length) {
//            System.out.println(Arrays.toString(selected));

            int sum = 0;
            for(int i=0; i<selected.length; i++)
                sum += selected[i];

            if(sum == 0) {
                answer++;
//                System.out.println(Arrays.toString(selected));
            }
            return;
        }

        if(options_idx == arr.length) {
            return;
        }

        selected[selected_idx] = arr[options_idx];
        combi(arr, selected, selected_idx+1, options_idx+1);
        combi(arr, selected, selected_idx, options_idx+1);

        // 같은 원소가 여러 선택되도 되는 경우
//        combi(arr, selected, selected_idx+1, options_idx);
//        combi(arr, selected, selected_idx, options_idx+1);
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