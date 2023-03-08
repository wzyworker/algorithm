package com.wzy.recursion;

import java.util.Stack;

/**
 * @author wzy
 * @date 2023年02月27日 22:50
 */
public class ReverseStack {

    public static int f(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) {
            return;
        }else {
            int i = f(stack);
            reverse(stack);
            stack.push(i);
        }
    }

}
