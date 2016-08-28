package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class ColumnName implements Visitable {
    private TableName tableName;
    private ColumnIdentifier columnIdentifier;
    private UserDefinedName aliasName;

    public ColumnName(final ColumnIdentifier columnIdentifier) {
        this.columnIdentifier = columnIdentifier;
    }

    public ColumnName(final String rawName) {
        if (rawName.contains(".")) {
            final String[] names = rawName.split("\\.");
            tableName = new TableName(new UserDefinedName(names[0]));
            columnIdentifier = new ColumnIdentifier(new UserDefinedName(names[1]));
        } else {
            columnIdentifier = new ColumnIdentifier(new UserDefinedName(rawName));
        }
    }

    public UserDefinedName getAliasName() {
        return aliasName;
    }

    public ColumnName as(final UserDefinedName aliasName) {
        this.aliasName = aliasName;
        return this;
    }

    public TableName getTableName() {
        return tableName;
    }

    public void setTableName(final TableName tableName) {
        this.tableName = tableName;
    }

    public ColumnIdentifier getColumnIdentifier() {
        return columnIdentifier;
    }

    public ComparisonPredicate eq(final String value) {
        return new ComparisonPredicate(new Express(this), BinaryOperator.EQ, new Express(value));
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
