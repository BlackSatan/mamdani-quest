package com.blacksatan;

import com.blacksatan.fuzzyset.FuzzySetInterface;

public class Condition extends Statement {

    public Condition(String name, Variable variable, FuzzySetInterface term) {
        super(name, variable, term);
    }
}
