package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public enum UnaryOperator implements Visitable{
    POSITIVE("+"), NEGATIVE("-");
    private final String operator;

    UnaryOperator(final String operator) {
        this.operator = operator;
    }



    public String getOperator() {
        return operator;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
