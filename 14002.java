import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer>[] max = new ArrayList[n];
        max[0] = new ArrayList<>();
        max[0].add(arr[0]);


        for(int i=1; i<n; i++) {
            int highest = 1;
            ArrayList<Integer> temp = null;

            for(int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i] && highest < 1+max[j].size()) {
                    temp = max[j];
                    highest = 1+max[j].size();
                }

            }

            if(temp == null) {
                max[i] = new ArrayList<>();
                max[i].add(arr[i]);
            }

            else {
                max[i] = (ArrayList)temp.clone();
                max[i].add(arr[i]);
            }
        }

        int size = 0;
        int idx = 0;

        for(int i=0; i<n; i++) {
            if(max[i].size() > size) {
                size = max[i].size();
                idx = i;
            }
        }

        System.out.println(max[idx].size());
        for(int i=0; i<max[idx].size(); i++) {
            System.out.print(Integer.toString(max[idx].get(i)) + " ");
        }
    }
}