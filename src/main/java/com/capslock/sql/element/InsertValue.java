package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by alvin.
 */
public class InsertValue  implements Visitable{
    private Literal literal;
    private boolean isNull;

    public InsertValue(final Literal literal) {
        this.literal = literal;
    }

    private InsertValue(final boolean isNull) {
        this.isNull = isNull;
    }

    public static InsertValue getNULL() {
        return NULL;
    }

    public Literal getLiteral() {
        return literal;
    }

    public boolean isNull() {
        return isNull;
    }

    public static final InsertValue NULL = new InsertValue(true);

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
