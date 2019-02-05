import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        do {
            for(int a : arr) {
                System.out.print(a + " ");
            }
            System.out.print("\n");
        }
        while(getNextPer(arr));

    }


    public static boolean getNextPer(int[] arr) {

            int i;
            for(i=arr.length-1; i-1 >= 0 && arr[i-1] > arr[i]; i--);

            if (i-1 < 0) {
                return false;
            }

            int j = i;
            while(j < arr.length-1 && arr[i-1] < arr[j+1])
                j++;


            int temp = arr[i-1];
            arr[i-1] = arr[j];
            arr[j] = temp;

            for(int k=arr.length-1; i<k; i++, k--) {
                temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }

            return true;
        }
}
