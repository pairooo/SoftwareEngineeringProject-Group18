package it.unisa.se.calculator.model.operations.arithmetic;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * The class implements the interface Operation
 * It provides a method to execute multiplication.
 */
public class MultiplyOperation implements Operation {
    /**
     * The function execute is used to calculate the multiplication between the first two operands taken from the stack.
     * Then it pushes the result into the stack.
     */

    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(2).forEachRemaining(operands::add);


        ComplexNumber result = ComplexNumber.multiply(operands.get(0),operands.get(1));
        complexNumberStack.push(result);
    }
}
