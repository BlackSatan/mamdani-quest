package com.blacksatan.dev;

import com.blacksatan.fuzzy.fuzzyset.FuzzySetInterface;

import java.util.List;
import java.util.stream.Collectors;

public class NotFuzzySet implements FuzzySetInterface {
    private Integer goal;

    NotFuzzySet(Integer goal) {
        this.goal = goal;
    }

    public double getValue(double value) {
        if (value == goal) {
            return 1;
        }
        return (1 / Math.abs(value - goal));
    }
}
