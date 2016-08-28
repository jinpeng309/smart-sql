package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public enum BinaryOperator implements Visitable {
    EQ("="), MULTIPLE("*"), DIVIDE("/");
    private final String operator;

    BinaryOperator(final String operator) {
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
