package p05Calculator;

import java.util.Deque;

public class MSOperation implements Operation {

    private Deque<Integer> memoryStack;

    public MSOperation(Deque<Integer> memoryStack) {
        this.memoryStack = memoryStack;
    }

    @Override
    public void addOperand(int operand) {
        this.memoryStack.push(operand);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public int getResult() {
        return this.memoryStack.peek();
    }

}