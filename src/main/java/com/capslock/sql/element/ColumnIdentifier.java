package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class ColumnIdentifier implements Visitable{
    private final UserDefinedName name;

    public ColumnIdentifier(final UserDefinedName name) {
        this.name = name;
    }

    public UserDefinedName getName() {
        return name;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
