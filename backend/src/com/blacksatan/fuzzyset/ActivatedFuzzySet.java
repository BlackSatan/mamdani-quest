package com.blacksatan.fuzzyset;

public class ActivatedFuzzySet implements FuzzySetInterface {

    private FuzzySetInterface fuzzySet;

    private Double truthDegree;

    public ActivatedFuzzySet(FuzzySetInterface fuzzySet, Double truthDegree) {
        this.fuzzySet = fuzzySet;
        this.truthDegree = truthDegree;
    }

    private double getActivatedValue(double x) {
        return Math.min(fuzzySet.getValue(x), truthDegree);
    }

    public double getValue(double x) {
        return getActivatedValue(x);
    }
}
