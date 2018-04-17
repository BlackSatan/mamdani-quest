package com.blacksatan.dev;

import com.blacksatan.fuzzy.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuzzyAlgorithmBuilder {

    protected static List<Rule> getRules() {
        return new ArrayList<Rule>() {{
            add(new Rule(new ArrayList<Condition>() {{
                add(new Condition("rush", new Variable(0),
                        new NotFuzzySet(1))
                );
                add(new Condition("no prop", new Variable(1),
                        new NotFuzzySet(0))
                );
                add(new Condition("bad level", new Variable(2),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.badTeam))
                );
                add(new Condition("bad manage", new Variable(3),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.badManage))
                );
                add(new Condition("low load", new Variable(4),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.lowLoad))
                );
                add(new Condition("bad plan", new Variable(5),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.badManage))
                );
                add(new Condition("low salary", new Variable(6),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.lowSalary))
                );
                add(new Condition("bad zone", new Variable(7),
                        new NotFuzzySet(1))
                );
                add(new Condition("bad change", new Variable(8),
                        new NotFuzzySet(1))
                );
                add(new Condition("small team", new Variable(9),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.smallTeam))
                );
            }}, new ArrayList<Conclusion>(){{
                add(new Conclusion("wp", new Variable(0),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.wpStack), Conclusion.HIGH_WEIGHT)
                );
            }}
            ));


            add(new Rule(new ArrayList<Condition>() {{
                add(new Condition("no rush", new Variable(0),
                        new NotFuzzySet(2))
                );
                add(new Condition("no prop", new Variable(1),
                        new NotFuzzySet(0))
                );
                add(new Condition("avg level", new Variable(2),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.middleTeam))
                );
                add(new Condition("bad manage", new Variable(3),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.badManage))
                );
                add(new Condition("low load", new Variable(4),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.lowLoad))
                );
                add(new Condition("bad plan", new Variable(5),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.badManage))
                );
                add(new Condition("middle salary", new Variable(6),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.middleSalary))
                );
                add(new Condition("ok zone", new Variable(7),
                        new NotFuzzySet(2))
                );
                add(new Condition("ok change", new Variable(8),
                        new NotFuzzySet(2))
                );
                add(new Condition("avg team", new Variable(9),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.avgTeam))
                );
            }}, new ArrayList<Conclusion>(){{
                add(new Conclusion("lara", new Variable(0),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.laraStack), Conclusion.HIGH_WEIGHT)
                );
            }}
            ));

            add(new Rule(new ArrayList<Condition>() {{
                add(new Condition("no rush", new Variable(0),
                        new NotFuzzySet(3))
                );
                add(new Condition("no prop", new Variable(1),
                        new NotFuzzySet(0))
                );
                add(new Condition("avg level", new Variable(2),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.middleTeam))
                );
                add(new Condition("bad manage", new Variable(3),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodManage))
                );
                add(new Condition("middle load", new Variable(4),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.middleLoad))
                );
                add(new Condition("good plan", new Variable(5),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodManage))
                );
                add(new Condition("middle salary", new Variable(6),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.middleSalary))
                );
                add(new Condition("ok zone", new Variable(7),
                        new NotFuzzySet(3))
                );
                add(new Condition("ok change", new Variable(8),
                        new NotFuzzySet(2))
                );
                add(new Condition("avg team", new Variable(9),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.avgTeam))
                );
            }}, new ArrayList<Conclusion>(){{
                add(new Conclusion("py", new Variable(0),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.pyStack), Conclusion.DEFAULT_WEIGHT)
                );
            }}
            ));

            add(new Rule(new ArrayList<Condition>() {{
                add(new Condition("no rush", new Variable(0),
                        new NotFuzzySet(3))
                );
                add(new Condition("prop", new Variable(1),
                        new NotFuzzySet(1))
                );
                add(new Condition("avg level", new Variable(2),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodTeam))
                );
                add(new Condition("bad manage", new Variable(3),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodManage))
                );
                add(new Condition("low load", new Variable(4),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.highLoad))
                );
                add(new Condition("bad plan", new Variable(5),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodManage))
                );
                add(new Condition("middle salary", new Variable(6),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.highSalary))
                );
                add(new Condition("ok zone", new Variable(7),
                        new NotFuzzySet(4))
                );
                add(new Condition("ok change", new Variable(8),
                        new NotFuzzySet(3))
                );
                add(new Condition("big team", new Variable(9),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.bigTeam))
                );
            }}, new ArrayList<Conclusion>(){{
                add(new Conclusion("java", new Variable(0),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.javaStack), Conclusion.DEFAULT_WEIGHT)
                );
            }}
            ));

            add(new Rule(new ArrayList<Condition>() {{
                add(new Condition("no rush", new Variable(0),
                        new NotFuzzySet(4))
                );
                add(new Condition("no prop", new Variable(1),
                        new NotFuzzySet(1))
                );
                add(new Condition("good level", new Variable(2),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodTeam))
                );
                add(new Condition("good manage", new Variable(3),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodManage))
                );
                add(new Condition("high load", new Variable(4),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.highLoad))
                );
                add(new Condition("good plan", new Variable(5),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodManage))
                );
                add(new Condition("high salary", new Variable(6),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.highSalary))
                );
                add(new Condition("cool zone", new Variable(7),
                        new NotFuzzySet(5))
                );
                add(new Condition("good change", new Variable(8),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.goodManage))
                );
                add(new Condition("big team", new Variable(9),
                        new NotFuzzySet(4))
                );
            }}, new ArrayList<Conclusion>(){{
                add(new Conclusion("haskell", new Variable(0),
                        new FuzzySetTrapezoid(FuzzySetTrapezoidIntervals.haskellStack), Conclusion.DEFAULT_WEIGHT)
                );
            }}
            ));

        }};
    }

    public MamdaniAlgorithm build(double [] inputs) {
        System.out.println("inputs:" + Arrays.toString(inputs));
        // {"start":"1","prop":true,"level":"1","manage":"1","load":"10","plan":"2","salary":"500","zone":"1","change":"4","workers":"1"}
        return new MamdaniAlgorithm(getRules(), inputs);
    }
}
