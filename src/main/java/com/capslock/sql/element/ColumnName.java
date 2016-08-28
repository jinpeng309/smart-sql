package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class ColumnName implements Visitable{
    private TableName tableName;
    private ColumnIdentifier columnIdentifier;
    private UserDefinedName aliasName;

    public ColumnName(final ColumnIdentifier columnIdentifier) {
        this.columnIdentifier = columnIdentifier;
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

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
