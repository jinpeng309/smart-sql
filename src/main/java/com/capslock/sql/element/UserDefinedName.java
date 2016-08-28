package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class UserDefinedName implements Visitable {
    private final String name;

    public UserDefinedName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void visit(final Visitor visitor) {

        visitor.visit(this);
    }
}
