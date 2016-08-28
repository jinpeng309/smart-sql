package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class Factor implements Visitable {
    private UnaryOperator operator;
    private Literal literal;
    private Express express;

    public UnaryOperator getOperator() {
        return operator;
    }

    public void setOperator(final UnaryOperator operator) {
        this.operator = operator;
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(final Literal literal) {
        this.literal = literal;
    }

    public Express getExpress() {
        return express;
    }

    public void setExpress(final Express express) {
        this.express = express;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
