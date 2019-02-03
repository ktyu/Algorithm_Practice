import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int MAX = 1000000;
        boolean arr[] = new boolean[MAX+1];

        for(int i=2; i<=MAX; i++) {
            if(!(arr[i])) {
                for(int j=i+i; j<=MAX; j+=i) {
                    arr[j] = true;
                }
            }
        }


        while(true) {
            int tc = sc.nextInt();
            if(tc==0)
                break;
            for(int i=3; i<=MAX; i++) {
                if(!(arr[i]) && !(arr[tc-i])) {
                    System.out.println(tc + " = " + i + " + " + (tc-i));
                    break;
                }
                if(i==MAX)
                    System.out.println("Goldbach's conjecture is wrong.");
            }
        }


    }
}
