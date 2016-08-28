package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class Literal implements Visitable{
    private String data;

    public Literal(final String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
