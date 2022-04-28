package suanfamiji.p134;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] array = {2,1,2,4,3};
        getNumber(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
    private static void getNumber(int[] array){
        // 所以在原本的内容上进行添加是能够正常的进行修改的，现在的问题是我修改该的内容不是我想要的

        int length = array.length;
        int[] answear = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--) {

            while(!stack.isEmpty()&&stack.peek()<=array[i]){
                stack.pop();
            }
            int shouldAdd = stack.isEmpty()?-1:stack.peek();
            answear[i] = shouldAdd;
            stack.push(array[i]);

        }
        for (int i = 0; i < answear.length; i++) {
            array[i] = answear[i];
        }
    }
}
