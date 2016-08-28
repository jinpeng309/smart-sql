package com.capslock.sql;

import com.capslock.sql.element.DeleteStatementSearched;
import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.TableName;

/**
 * Created by capslock1874.
 */
public class DeleteStatementBuilder {
    private final TableName tableName;
    private SearchCondition condition;

    public DeleteStatementBuilder(final TableName tableName) {
        this.tableName = tableName;
    }

    public SearchCondition getCondition() {
        return condition;
    }

    public TableName getTableName() {
        return tableName;
    }

    public DeleteStatementBuilder where(final SearchCondition condition) {
        this.condition = condition;
        return this;
    }

    public DeleteStatementSearched build() {
        return new DeleteStatementSearched(tableName, condition);
    }

    public String toSql() {
        final Visitor visitor = new Visitor(new StringBuilder());
        visitor.visit(build());
        return visitor.toSql();
    }
}
