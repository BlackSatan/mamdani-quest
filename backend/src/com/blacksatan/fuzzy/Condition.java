package com.blacksatan.fuzzy;

import com.blacksatan.fuzzy.fuzzyset.FuzzySetInterface;

public class Condition extends Statement {

    public Condition(String name, Variable variable, FuzzySetInterface term) {
        super(name, variable, term);
    }
}
