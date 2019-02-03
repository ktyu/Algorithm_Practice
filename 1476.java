import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt(); // 1~15
        int s = sc.nextInt(); // 1~28
        int m = sc.nextInt(); // 1~19

        int a=0, b=0, c=0, cnt=0;
        while(!(a==e && b==s && c==m)) {
            a++;
            b++;
            c++;
            cnt++;

            if(a>15)
                a = 1;
            if(b>28)
                b = 1;
            if(c>19)
                c = 1;
        }
        System.out.println(cnt);
    }
}
