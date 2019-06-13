import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MyStatck {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();//辅助栈,注意一点：辅助栈的作用是存放最小元素的，可以不存放所有元素，时刻保持栈顶为最小元素即可


    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else if(stack2.peek()>=node) {
            stack2.push(node);
        }
    }

    public void pop() {
        if(stack1.peek()==stack2.peek()){
            //如果stack1弹出的是最小元素，则stack2也需要弹出栈顶的最小元素，更新最小元素
            stack1.pop();
            stack2.pop();
        }else if(stack1.peek()!=stack2.peek()){
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
