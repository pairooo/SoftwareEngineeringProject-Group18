package it.unisa.se.calculator.model.operations.positional;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.util.Iterator;
/**
 * TThe class extends the class Operation.
 * It provides a method to execute over operation.
 * */
public class OverOperation implements Operation {

    /**
     * The function execute is used to take the second to last element into the stack.
     * Then it pushes the element into the stack.
     */
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        Iterator<ComplexNumber> operands = complexNumberStack.getOperand(2);
        ComplexNumber topComplexNumber = operands.next();
        ComplexNumber dupComplexNumber = operands.next();
        complexNumberStack.push(dupComplexNumber);
        complexNumberStack.push(topComplexNumber);
        complexNumberStack.push(dupComplexNumber);
    }
}
