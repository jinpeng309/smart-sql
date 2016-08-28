package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class Term implements Visitable {
    private Factor factor;
    private Term anotherTerm;
    private BinaryOperator operator;

    public Term(final Factor factor) {
        this.factor = factor;
    }


    public Factor getFactor() {
        return factor;
    }

    public void setFactor(final Factor factor) {
        this.factor = factor;
    }

    public Term getAnotherTerm() {
        return anotherTerm;
    }

    public void setAnotherTerm(final Term anotherTerm) {
        this.anotherTerm = anotherTerm;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    public void setOperator(final BinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
