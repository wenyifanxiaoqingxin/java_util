package Demo.Test.Stack;

import java.util.Stack;

/**
 * Created by fx on 2018/2/6.
 */
public class DemoStack {
    public static void main(String[] args){

        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack:"+st);

        showPush(st,42);
        showPush(st,66);
        showPush(st,99);

        showPop(st);
        showPop(st);
        showPop(st);

        try {
            showPop(st);
        }catch (Exception e){
            System.out.println("the stack is null");
        }
    }

    static void showPush(Stack<Integer> st,int a){
        st.push(new Integer(a));
        System.out.println("push("+a+")");
        System.out.println("stack:"+st);

    }

    static void showPop(Stack<Integer> st){

        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack:"+st);
    }

}
