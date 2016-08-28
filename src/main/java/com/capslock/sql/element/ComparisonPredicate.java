package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class ComparisonPredicate implements Visitable{
    private final Express leftExpress;
    private final BinaryOperator binaryOperator;
    private final Express rightExpress;

    public ComparisonPredicate(final Express leftExpress, final BinaryOperator binaryOperator, final Express rightExpress) {
        this.leftExpress = leftExpress;
        this.binaryOperator = binaryOperator;
        this.rightExpress = rightExpress;
    }

    public Express getLeftExpress() {
        return leftExpress;
    }

    public BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    public Express getRightExpress() {
        return rightExpress;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
