package p05Calculator;

import java.util.Deque;

public class MROperation implements Operation {

    private Deque<Integer> memoryStack;

    public MROperation(Deque<Integer> memoryStack) {
        this.memoryStack = memoryStack;
    }

    @Override
    public void addOperand(int operand) {
        
    }

    @Override
    public boolean isCompleted() {
        return this.memoryStack.size() != 0;
    }

    @Override
    public int getResult() {
        return this.memoryStack.pop();
    }

}
