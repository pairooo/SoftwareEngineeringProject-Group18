package it.unisa.se.calculator.model.operations.trigonometric;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class ArgOperation implements Operation {
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(1).forEachRemaining(operands::add);

        double real = operands.get(0).getReal();
        double imaginary = operands.get(0).getImaginary();
        double result = Math.atan2(imaginary, real);
        complexNumberStack.push(new ComplexNumber (result,0));

    }
}
