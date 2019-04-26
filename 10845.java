import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<num; i++) {
            String instruction = sc.nextLine();
            
            String[] s = instruction.split(" ");

            if(s[0].equals("push")) {
                q.add(Integer.valueOf(s[1]));
            }

            else if(s[0].equals("pop")) {
                if(q.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(q.remove());
            }

            else if(s[0].equals("size")) {
                System.out.println(q.size());
            }

            else if(s[0].equals("empty")) {
                if(q.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }

            else if(s[0].equals("front")) {
                if(q.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(q.peek());
            }

            else if(s[0].equals("back")) {
                if(q.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(((LinkedList<Integer>) q).peekLast());
            }
        }
    }
}