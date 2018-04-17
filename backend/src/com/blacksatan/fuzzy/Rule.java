package com.blacksatan.fuzzy;

import com.blacksatan.fuzzy.Conclusion;
import com.blacksatan.fuzzy.Condition;

import java.util.List;

public class Rule {

    private List<Condition> conditions;

    private List<Conclusion> conclusions;

    public Rule(List<Condition> conditions, List<Conclusion> conclusions) {
        this.conditions = conditions;
        this.conclusions = conclusions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<Conclusion> getConclusions() {
        return conclusions;
    }
}