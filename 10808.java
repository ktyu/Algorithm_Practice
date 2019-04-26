import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine().trim();

        int[] arr = new int[26];

        for(int i=0; i<word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }

}