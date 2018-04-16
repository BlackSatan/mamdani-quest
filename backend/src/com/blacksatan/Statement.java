package com.blacksatan;

import com.blacksatan.fuzzyset.FuzzySetInterface;

public class Statement {

    private FuzzySetInterface term;

    private String name;

    private Variable variable;

    public FuzzySetInterface getTerm() {
        return term;
    }

    public String getName() {
        return name;
    }

    public Variable getVariable() {
        return variable;
    }

    public Statement(String name, Variable variable, FuzzySetInterface term) {
        this.name = name;
        this.term = term;
        this.variable = variable;
    }
}
