package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */

// boolean-term ::= boolean-factor [AND boolean-term]
public class BooleanTerm implements Visitable {
    private final BooleanFactor factor;
    private BooleanTerm term;

    public BooleanTerm(final ComparisonPredicate comparisonPredicate) {
        this.factor = new BooleanFactor(new BooleanPrimary(comparisonPredicate));
    }

    public BooleanTerm(final BooleanFactor factor) {
        this.factor = factor;
    }

    public BooleanTerm and(final BooleanTerm anotherTerm) {
        if (term == null) {
            setTerm(anotherTerm);
        } else {
            term.and(anotherTerm);
        }
        return this;
    }

    public SearchCondition or(final BooleanTerm anotherTerm) {
        final SearchCondition condition = new SearchCondition(this);
        condition.setSearchCondition(new SearchCondition(anotherTerm));
        return condition;
    }


    public BooleanFactor getFactor() {
        return factor;
    }

    public BooleanTerm getTerm() {
        return term;
    }

    public void setTerm(final BooleanTerm term) {
        this.term = term;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
