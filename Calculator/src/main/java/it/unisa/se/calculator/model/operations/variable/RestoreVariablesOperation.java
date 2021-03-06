package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.structures.VariablesMap;
import it.unisa.se.calculator.model.structures.VariablesMapStack;
import it.unisa.se.calculator.model.operations.Operation;

public class RestoreVariablesOperation implements Operation {
    private VariablesMap variablesMap;

    public RestoreVariablesOperation(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;
    }

    /**
     * The method executes the restore of the last variable copy.
     */
    public void execute() {
        VariablesMapStack variablesMapStack = VariablesMapStack.getInstance();
        variablesMap.clear();
        variablesMap.putAll(variablesMapStack.pop());
    }


}
