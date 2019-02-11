import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int multiple = sc.nextInt();
        int divide = sc.nextInt();

        calc(nums, new int[n-1], 0, plus, minus, multiple, divide);

        System.out.println(max);
        System.out.println(min);
    }

    public static int max = -1000000001;
    public static int min = 1000000001;

    public static void calc(int[] nums, int[] operators, int i, int plus, int minus, int multiple, int divide) {

        // operators가 다 찼으면 계산해서 결과 저장
        if(i == operators.length) {
            int result = nums[0];
            for(int j=0; j<operators.length; j++) {
                if(operators[j] == 1)
                    result += nums[j+1];

                else if(operators[j] == 2)
                    result -= nums[j+1];

                else if(operators[j] == 3)
                    result *= nums[j+1];

                else if(operators[j] == 4)
                    result /= nums[j+1];
            }

            if(result > max)
                max = result;
            if(result < min)
                min = result;

            return;
        }

        if(plus > 0) {
            operators[i] = 1;
            calc(nums, operators, i+1, plus-1, minus, multiple, divide);
        }

        if(minus > 0) {
            operators[i] = 2;
            calc(nums, operators, i+1, plus, minus-1, multiple, divide);
        }

        if(multiple > 0) {
            operators[i] = 3;
            calc(nums, operators, i+1, plus, minus, multiple-1, divide);
        }

        if(divide > 0) {
            operators[i] = 4;
            calc(nums, operators, i+1, plus, minus, multiple, divide-1);
        }

        return;
    }
}
