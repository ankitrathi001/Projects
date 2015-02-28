package Stack;

import java.util.Stack;

public class ValidParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("{([])}"));
		System.out.println(isValid("{([])}}"));
	}
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(c=='(')
        		stack.push(')');
        	else if(c=='{')
        		stack.push('}');
        	else if(c=='[')
        		stack.push(']');
        	else{
        		if(stack.isEmpty())
        			return false;
        		char x = stack.pop();
        		if(x!=c)
        			return false;
        	}
        }
        if(stack.isEmpty())
        	return true;
        return false;
    }
}
