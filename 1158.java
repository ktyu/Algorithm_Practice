import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        System.out.print('<');
        while(true) {
            for(int i=m; i>1 && queue.peek() != null; i--) {
                queue.offer(queue.poll());
            }

            System.out.printf("%d", queue.poll());

            if(queue.isEmpty()) {
                System.out.print(">\n");
                break;
            }
            else {
                System.out.print(", ");
            }
        }

    }
}