package p05Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class InputInterpreter {
    private CalculationEngine engine;
    private Deque<Integer> memoryStack;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memoryStack = new ArrayDeque<>();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        switch(operation) {
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisionOperation();
            case "ms":
                return new MSOperation(memoryStack);
            case "mr":
                return new MROperation(memoryStack);
            default:
                return null;
        }
    }
}
