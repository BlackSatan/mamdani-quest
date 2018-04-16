package com.blacksatan;

import com.blacksatan.sport.FuzzySetTrapezoid;
import com.blacksatan.sport.FuzzySetTrapezoidIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Rule> getRules() {
        return new ArrayList<Rule>() {{
            add(new Rule(new ArrayList<Condition>() {{
                    add(new Condition("Morning or Lunch", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.firstDayPartInterval))
                    );
                    add(new Condition("Good Feeling", new Variable(1),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodFeelingInterval))
                    );
                }}, new ArrayList<Conclusion>(){{
                    add(new Conclusion("Hard Work", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.hardWork), Conclusion.DEFAULT_WEIGHT)
                    );
                }}
            ));
            add(new Rule(new ArrayList<Condition>() {{
                    add(new Condition("Evening", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.secondDayPartInterval))
                    );
                    add(new Condition("Good Feeling", new Variable(1),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodFeelingInterval))
                    );
                }}, new ArrayList<Conclusion>(){{
                    add(new Conclusion("Normal Work", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.normalWork), Conclusion.DEFAULT_WEIGHT)
                    );
                }}
            ));
            add(new Rule(new ArrayList<Condition>() {{
                    add(new Condition("Morning or Lunch", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.firstDayPartInterval))
                    );
                    add(new Condition("Middle Feeling", new Variable(1),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.middleFeelingInterval))
                    );
                }}, new ArrayList<Conclusion>(){{
                    add(new Conclusion("Average Work", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.averageWork), Conclusion.DEFAULT_WEIGHT)
                    );
                }}
            ));
            add(new Rule(new ArrayList<Condition>() {{
                    add(new Condition("Morning or Lunch", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.firstDayPartInterval))
                    );
                    add(new Condition("Bad Feeling", new Variable(1),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.badFeelingInterval))
                    );
                }}, new ArrayList<Conclusion>(){{
                    add(new Conclusion("Relax Work", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.relaxWork), Conclusion.DEFAULT_WEIGHT)
                    );
                }}
            ));
            add(new Rule(new ArrayList<Condition>() {{
                    add(new Condition("Evening", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.secondDayPartInterval))
                    );
                    add(new Condition("Bad Feeling", new Variable(1),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.badFeelingInterval))
                    );
                }}, new ArrayList<Conclusion>(){{
                    add(new Conclusion("Not a Real Work", new Variable(0),
                            new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.looksLikeWork), Conclusion.DEFAULT_WEIGHT)
                    );
                }}
            ));
        }};
    }


    public static void main(String[] args) {
        MamdaniAlgorithm algorithm = new MamdaniAlgorithm(getRules(), new double[] {8, 80});
        List<Double> result = algorithm.run();
        System.out.println("Algorithm result: " + Arrays.toString(result.toArray()));
    }
}
