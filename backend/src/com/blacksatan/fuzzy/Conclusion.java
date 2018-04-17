package com.blacksatan.fuzzy;

import com.blacksatan.fuzzy.fuzzyset.FuzzySetInterface;

public class Conclusion extends Statement {

    public static final Double LOW_WEIGHT = 0.5;
    public static final Double DEFAULT_WEIGHT = 1.0;
    public static final Double HIGH_WEIGHT = 1.5;

    private Double weight;

    public Conclusion(String name, Variable variable, FuzzySetInterface term, Double weight) {
        super(name, variable, term);
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }
}
