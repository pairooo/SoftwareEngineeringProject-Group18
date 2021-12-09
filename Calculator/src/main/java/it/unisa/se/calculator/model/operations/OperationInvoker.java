package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.CustomOperationMap;

import java.util.Map;
/**
 * The class has a map that stores as in a dictionary references to objects implementing Operation interface.
 * The class allows the invocation of a particular operation onto the stack data structure .
 *
 * */

public class OperationInvoker {
    private OperationMap operationMap;
    private CustomOperationMap customOperationMap;

    /**
     * The constructor of the class initialises the data structure with all the operations implemented
     * in the calculator.
     */
    public OperationInvoker(OperationMap operationMap,CustomOperationMap customOperationMap) {
        this.operationMap = operationMap;
        this.customOperationMap = customOperationMap;
    }

    public void resolve(String operationString){
        ComplexNumber complexNumber = ComplexNumber.getComplexNumberFromString(operationString);
        if (complexNumber != null)
            ComplexNumberStack.getInstance().push(complexNumber);
        else
            executeOperation(operationString);
    }



    /**
     * The method checks at first if there exists an operation with the specified name.
     * If it exists then it is executed, on the contrary it is thrown a Runtime Exception.
     *
     * @param operationString the string representing the operation inserted and that has to be executed.
     */
    public void executeOperation(String operationString){
        Operation operation= operationMap.get(operationString);
        if(operation == null)
           executeCustomOperation(operationString);
        else
            operation.execute();

    }

    public void executeCustomOperation(String operationName){
        String operations = customOperationMap.get(operationName);
        if(operations == null)
            throw new NotSupportedOperationException("Operation "+operationName+" not found");
        String[] split = operations.split("\\s+");
        for (String operation :split ) {
            resolve(operation);
        }
    }


}
