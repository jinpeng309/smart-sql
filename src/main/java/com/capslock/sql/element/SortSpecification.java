package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class SortSpecification implements Visitable{
    private int columnIndex = -1;
    private ColumnName columnName;

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(final int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public ColumnName getColumnName() {
        return columnName;
    }

    public void setColumnName(final ColumnName columnName) {
        this.columnName = columnName;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
