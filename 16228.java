import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        // 후위 표기식으로 바꿔서 큐에 넣기
        Queue<String> converted = new LinkedList<>();

        String s;
        Stack<String> temp = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) { // number
                StringBuffer num = new StringBuffer();
                num.append(str.charAt(i));
                while(++i < str.length() && Character.isDigit(str.charAt(i)))
                    num.append(str.charAt(i));
                i--;
                converted.offer(num.toString());
            }

            else if(str.charAt(i) == '(') {
                temp.push("(");
            }

            else if(str.charAt(i) == ')') {
                s = temp.pop();
                while(!(s.equals("("))) {
                    converted.offer(s);
                    s = temp.pop();
                }
            }

            else if(str.charAt(i) =='<' || str.charAt(i) =='>'){
                if(temp.isEmpty())
                    temp.push(String.valueOf(str.charAt(i++))); // skip '?'
                else {
                    while(!(temp.isEmpty()) && (temp.peek().equals("<") || (temp.peek().equals(">"))))
                        converted.offer(temp.pop());
                    temp.push(String.valueOf(str.charAt(i++))); // skip '?'
                }
            }

            else { // '+' or '-'
                if(temp.isEmpty())
                    temp.push(String.valueOf(str.charAt(i)));
                else {
                    while(!(temp.isEmpty()) && !(temp.peek().equals("(")))
                        converted.offer(temp.pop());
                    temp.push(String.valueOf(str.charAt(i)));
                }
            }
        }
        // 스택에 남아있는 것들 처리
        while(!temp.isEmpty())
            converted.offer(temp.pop());


        // 큐에 후위표기식으로 들어가 있는 식을 하나씩 꺼내면서 계산, temp 스택은 비어있는게 보장되므로 재사용함
        while(!converted.isEmpty()) {
            // 연산자인 경우
            if(converted.peek().equals("<") || converted.peek().equals(">") || converted.peek().equals("+") || converted.peek().equals("-")) {

                char op = converted.poll().charAt(0);
                int a = Integer.valueOf(temp.pop());
                int b = Integer.valueOf(temp.pop());

                if(op == '<') {
                    if(a<b) temp.push(String.valueOf(a));
                    else temp.push(String.valueOf(b));
                }

                else if(op == '>') {
                    if(a>b) temp.push(String.valueOf(a));
                    else temp.push(String.valueOf(b));
                }

                else if(op == '+')
                    temp.push(String.valueOf(a+b));

                else if(op == '-')
                    temp.push(String.valueOf(b-a));
            }
            
            // 숫자일 경우 스택에 저장
            else { 
                temp.push(converted.poll());
            }
        }
        // 최종 결과 출력
        System.out.println(temp.pop());
    }
}