package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class Express implements Visitable {
    private Term term;
    private Express express;
    private BinaryOperator binaryOperator;

    public Term getTerm() {
        return term;
    }

    public void setTerm(final Term term) {
        this.term = term;
    }

    public Express getExpress() {
        return express;
    }

    public void setExpress(final Express express) {
        this.express = express;
    }

    public BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    public void setBinaryOperator(final BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
