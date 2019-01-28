import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<String> stack = new Stack<>();
        int result = 0;

        try {
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') // 읽은 문자가 여는 괄호인 경우
                    stack.push(String.valueOf(c)); // 무조건 스택에 푸시하고 다음 문자 검사

                else if (c == ')') { // 읽은 문자가 닫는 소괄호인 경우
                    int val = 0;

                    while (!(stack.peek().equals("("))) { // 괄호 사이에 있는 숫자 모두 더하기
                        val += Integer.valueOf(stack.pop());
                    }
                    if (val == 0) // 괄호사이에 숫자가 없는 경우 1로 셋팅
                        val = 1;

                    stack.pop(); // 여는 괄호 스택에서 제거
                    stack.push(String.valueOf(val * 2)); // 계산한 숫자 스택에 추가
                }

                else if (c == ']') { // 읽은 문자가 닫는 대괄호인 경우
                    int val = 0;

                    while (!(stack.peek().equals("["))) { // 괄호 사이에 있는 숫자 모두 더하기
                        val += Integer.valueOf(stack.pop());
                    }
                    if (val == 0) // 괄호사이에 숫자가 없는 경우 1로 셋팅
                        val = 1;

                    stack.pop(); // 여는 괄호 스택에서 제거
                    stack.push(String.valueOf(val * 3)); // 계산한 숫자 스택에 추가
                }
            }

            for (String s : stack) { // 스택의 값들 더하기
                result += Integer.valueOf(s);
            }

        } catch(Exception e) { // 올바르지 못한 입력
            result = 0;
        }

        System.out.println(result);
    }
}