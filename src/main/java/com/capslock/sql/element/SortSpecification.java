package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class SortSpecification implements Visitable {
    private int columnIndex = -1;
    private ColumnName columnName;
    private Order order = Order.ASC;

    public SortSpecification setOrder(final Order order) {
        this.order = order;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public SortSpecification setColumnIndex(final int columnIndex) {
        this.columnIndex = columnIndex;
        return this;
    }

    public ColumnName getColumnName() {
        return columnName;
    }

    public SortSpecification setColumnName(final ColumnName columnName) {
        this.columnName = columnName;
        return this;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
