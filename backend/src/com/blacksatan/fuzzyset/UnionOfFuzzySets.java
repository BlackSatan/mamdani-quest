package com.blacksatan.fuzzyset;

import java.util.ArrayList;
import java.util.List;

public class UnionOfFuzzySets implements FuzzySetInterface {
    private List<FuzzySetInterface> fuzzySets = new ArrayList<>();

    public UnionOfFuzzySets() {}

    public void addFuzzySet(FuzzySetInterface fuzzySet) {
        fuzzySets.add(fuzzySet);
    }

    private Double getMaxValue(Double x) {
        return fuzzySets.stream().map(item -> item.getValue(x)).max(Double::compare).orElse(0.0);
    }

    public double getValue(double value) {
        return getMaxValue(value);
    }
}
