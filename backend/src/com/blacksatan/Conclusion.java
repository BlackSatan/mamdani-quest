package com.blacksatan;

import com.blacksatan.fuzzyset.FuzzySetInterface;

public class Conclusion extends Statement {

    public static final Double DEFAULT_WEIGHT = 1.0;

    private Double weight;

    public Conclusion(String name, Variable variable, FuzzySetInterface term, Double weight) {
        super(name, variable, term);
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }
}
