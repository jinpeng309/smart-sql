package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class SetClause implements Visitable {
    private final ColumnName columnName;
    private final Express express;

    public SetClause(final ColumnName columnName, final Express express) {
        this.columnName = columnName;
        this.express = express;
    }

    public ColumnName getColumnName() {
        return columnName;
    }

    public Express getExpress() {
        return express;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
