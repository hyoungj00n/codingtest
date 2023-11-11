import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String bar = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int value =1;
        int result = 0;

        for (int i =0; i<bar.length(); i++){
            if (bar.charAt(i)=='('){
                stack.push(bar.charAt(i));
                value *= 2;
            }
            else if (bar.charAt(i)=='['){
                stack.push(bar.charAt(i));
                value *= 3;
            }
            else if (bar.charAt(i)==')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    result = 0;
                    break;
                }
                else if (bar.charAt(i-1)=='('){
                    
                    result += value;
                }

                stack.pop();
                value /= 2;
            }
            else if (bar.charAt(i) == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    result = 0;
                    break;
                }
                else if (bar.charAt(i-1) =='['){

                    result += value;
                }
                stack.pop();
                value /=3;
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : result);


    }
}
