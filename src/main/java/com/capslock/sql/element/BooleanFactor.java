package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class BooleanFactor implements Visitable{
    private boolean hasNot = false;
    private final BooleanPrimary primary;

    public BooleanFactor(final BooleanPrimary primary) {
        this.primary = primary;
    }

    public BooleanPrimary getPrimary() {
        return primary;
    }

    public boolean isHasNot() {
        return hasNot;
    }

    public void setHasNot(final boolean hasNot) {
        this.hasNot = hasNot;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}