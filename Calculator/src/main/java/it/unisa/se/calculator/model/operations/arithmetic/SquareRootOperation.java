package it.unisa.se.calculator.model.operations.arithmetic;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * The class extends the class Operation.
 * It provides a method to execute Square root.
 * */
public class SquareRootOperation implements Operation {
    /**
     * The function execute is used to calculate the square root on the first operand taken from the stack.
     * Then it pushes the result into the stack.
     */

    public void execute(){
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(1).forEachRemaining(operands::add);


        ComplexNumber result = ComplexNumber.sqrt(operands.get(0));
        complexNumberStack.push(result);
    }
}
