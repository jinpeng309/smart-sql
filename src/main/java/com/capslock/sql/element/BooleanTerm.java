package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */

// boolean-term ::= boolean-factor [AND boolean-term]
public class BooleanTerm implements Visitable{
    private final BooleanFactor factor;
    private BooleanTerm term;

    public BooleanTerm(final BooleanFactor factor) {
        this.factor = factor;
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
