package com.blacksatan;

import com.blacksatan.fuzzyset.ActivatedFuzzySet;
import com.blacksatan.fuzzyset.FuzzySetInterface;
import com.blacksatan.fuzzyset.UnionOfFuzzySets;

import java.util.*;
import java.util.function.DoubleUnaryOperator;

public class MamdaniAlgorithm {

    private List<Rule> rules;
    private double[] inputData;

    public MamdaniAlgorithm(List<Rule> rules, double[] inputData) {
        this.rules = rules;
        this.inputData = inputData;
    }

    public List<Double> run() {
        List<Double> fuzzificated = fuzzification(inputData);
        List<Double> aggregated = aggregation(fuzzificated);
        List<ActivatedFuzzySet> activated = activation(aggregated);
        List<UnionOfFuzzySets> accumulated = accumulation(activated);
        return defuzzification(accumulated);
    }

    private List<Double> fuzzification(double[] inputData) {
        List<Double> b = new ArrayList<>();
        for (Rule rule : rules) {
            for (Condition condition : rule.getConditions()) {
                int j = condition.getVariable().getIndex();
                FuzzySetInterface term = condition.getTerm();
                b.add(term.getValue(inputData[j]));
            }
        }
        return b;
    }

    private List<Double> aggregation(List<Double> b) {
        int i = 0;
        int j = 0;
        List<Double> c = new ArrayList<>();
        for (Rule rule : rules) {
            double truthOfConditions = 1.0;
            for (Condition condition : rule.getConditions()) {
                truthOfConditions = Math.min(truthOfConditions, b.get(i));
                i++;
            }
            c.add(truthOfConditions);
        }
        return c;
    }

    private List<ActivatedFuzzySet> activation(List<Double> c) {
        int i = 0;
        List<ActivatedFuzzySet> activatedFuzzySets = new ArrayList<>();
        for (Rule rule : rules) {
            for (Conclusion conclusion : rule.getConclusions()) {
                activatedFuzzySets.add(new ActivatedFuzzySet(
                        conclusion.getTerm(), c.get(i) * conclusion.getWeight()
                ));
                i++;
            }
        }
        return activatedFuzzySets;
    }


    private List<UnionOfFuzzySets> accumulation(List<ActivatedFuzzySet> activatedFuzzySets) {
        Map<Integer, UnionOfFuzzySets> unionsOfFuzzySets =
                new HashMap<>();
        int i = 0;
        for (Rule rule : rules) {
            for (Conclusion conclusion : rule.getConclusions()) {
                int index = conclusion.getVariable().getIndex();
                if (!unionsOfFuzzySets.containsKey(index)) {
                    unionsOfFuzzySets.put(index, new UnionOfFuzzySets());
                }
                unionsOfFuzzySets.get(index).addFuzzySet(activatedFuzzySets.get(i));
                i++;
            }
        }
        return new ArrayList<>(unionsOfFuzzySets.values());
    }

    private List<Double> defuzzification(List<UnionOfFuzzySets> unionsOfFuzzySets) {
        List<Double> y = new ArrayList<>();
        for(UnionOfFuzzySets unionOfFuzzySets : unionsOfFuzzySets) {
            Double i1 = integral(unionOfFuzzySets, true);
            Double i2 = integral(unionOfFuzzySets, false);
            y.add(i1 / i2);
        }
        return y;
    }


    private Double integral(FuzzySetInterface fuzzySet, Boolean useX) {
        return integrate(0.0, 100.0, (x) -> useX ? x * fuzzySet.getValue(x) : fuzzySet.getValue(x));
    }

    public static Double integrate(Double a, Double b, DoubleUnaryOperator f) {
        Integer N = 10000;                    // precision parameter
        Double h = (b - a) / (N - 1);     // step size

        // 1/3 terms
        Double sum = 1.0 / 3.0 * (f.applyAsDouble(a) + f.applyAsDouble(b));

        // 4/3 terms
        for (Integer i = 1; i < N - 1; i += 2) {
            Double x = a + h * i;
            sum += 4.0 / 3.0 * f.applyAsDouble(x);
        }

        // 2/3 terms
        for (Integer i = 2; i < N - 1; i += 2) {
            Double x = a + h * i;
            sum += 2.0 / 3.0 * f.applyAsDouble(x);
        }

        return sum * h;
    }

}
