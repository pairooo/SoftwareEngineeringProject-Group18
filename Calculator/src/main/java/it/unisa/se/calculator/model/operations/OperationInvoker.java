package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.arithmetic.*;
import it.unisa.se.calculator.model.operations.stack.*;
import it.unisa.se.calculator.model.operations.variable.DecrementVariableOperation;
import it.unisa.se.calculator.model.operations.variable.IncrementVariableOperation;
import it.unisa.se.calculator.model.operations.variable.LoadVariableOperation;
import it.unisa.se.calculator.model.operations.variable.SaveVariableOperation;

import java.util.HashMap;
import java.util.Map;
/**
 * The class has a map that stores as in a dictionary references to objects implementing Operation interface.
 * The class allows the invocation of a particular operation onto the stack data structure .
 *
 * */

public class OperationInvoker {
    private Map<String,Operation> operationMap;

    /**
     * The constructor of the class initialises the data structure with all the operations implemented
     * in the calculator.
     */
    public OperationInvoker() {
        operationMap = new HashMap<>();
        operationMap.put("+",new SumOperation());
        operationMap.put("-",new SubtractOperation());
        operationMap.put("*",new MultiplyOperation());
        operationMap.put("/",new DivideOperation());
        operationMap.put("+-",new SignInversionOperation());
        operationMap.put("sqrt",new SquareRootOperation());
        //advanced operations
        operationMap.put("clear",new ClearOperation());
        operationMap.put("over",new OverOperation());
        operationMap.put("drop", new DropOperation());
        operationMap.put("dup", new DupOperation());
        operationMap.put("swap", new SwapOperation());
        //
        operationMap.put("<$", new LoadVariableOperation());
        operationMap.put(">$", new SaveVariableOperation());
        operationMap.put("+$", new IncrementVariableOperation());
        operationMap.put("-$", new DecrementVariableOperation());
    }

    /**
     *
     * @param stringOperation the string representing the operation inserted and that has to be executed.
     * The method checks at first if there exists an operation with the specified name.
     * If it exists then it is executed, on the contrary it is thrown a Runtime Exception.
     */

    public void execute(String stringOperation){

        Operation operation= operationMap.get(stringOperation);
        if(operation == null)
            throw new NotSupportedOperationException("Operation "+stringOperation+" not found");
        operation.execute();
    }


    public void execute(String stringOperation, VariablesMap variablesMap) {

        String variable = "" + stringOperation.charAt(stringOperation.length()-1);
        stringOperation = stringOperation.charAt(0)+"$";

        Operation operation= operationMap.get(stringOperation);
        operation.execute(variablesMap,variable);

    }
}
