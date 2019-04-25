import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        set = new HashSet<>();

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        go(new int[m], 0, 0);

    }

    static int[] arr;
    static HashSet<String> set;

    static String convert(int[] sel) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sel.length; i++) {
            sb.append(sel[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    static void go(int[] sel, int sel_idx, int arr_idx) {

        if(sel_idx == sel.length) {
            String str = convert(sel);

            if(!set.contains(str)) {
                set.add(str);
                System.out.println(str);
            }

            return;
        }

        for(int i=arr_idx; i<arr.length; i++) {
            sel[sel_idx] = arr[i];
            go(sel, sel_idx+1, i);
        }
    }

}