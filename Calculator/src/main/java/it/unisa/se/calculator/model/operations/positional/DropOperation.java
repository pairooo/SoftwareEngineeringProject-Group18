package it.unisa.se.calculator.model.operations.positional;

import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

/**
 * The class extends the class Operation.
 * It provides a method to execute Drop.
 * */
public class DropOperation implements Operation {
    /**
     * The function execute is used to calculate the drop of the top operand of the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        complexNumberStack.pop();
    }
}