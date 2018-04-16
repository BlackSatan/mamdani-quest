package com.blacksatan.sport;

import com.blacksatan.fuzzyset.FuzzySetInterface;

import java.util.List;
import java.util.stream.Collectors;

public class FuzzySetTrapezoid implements FuzzySetInterface {
    private List<Double> trapezoidIntervals;

    public FuzzySetTrapezoid(List<Integer> intervals) {
        trapezoidIntervals = intervals.parallelStream().mapToDouble(i->i)
                .boxed().collect(Collectors.toList());
    }

    public double getValue(double value) {
        if (value < trapezoidIntervals.get(0)) {
            return 0;
        } else if(trapezoidIntervals.get(0) < value && trapezoidIntervals.get(1) > value) {
            return (value - trapezoidIntervals.get(0)) / (trapezoidIntervals.get(1) - trapezoidIntervals.get(0));
        } else if(trapezoidIntervals.get(1) <= value && trapezoidIntervals.get(2) >= value) {
            return 1;
        } else if(trapezoidIntervals.get(2) < value && trapezoidIntervals.get(3) > value) {
            return (trapezoidIntervals.get(3) - value) / (trapezoidIntervals.get(3) - trapezoidIntervals.get(2));
        } else {
            return 0;
        }
    }
}
