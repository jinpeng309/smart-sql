package com.capslock.sql;

import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.TableName;

/**
 * Created by capslock1874.
 */
public class DeleteStatementSearched implements Visitable {
    private final TableName tableName;
    private final SearchCondition searchCondition;

    public DeleteStatementSearched(final TableName tableName, final SearchCondition searchCondition) {
        this.tableName = tableName;
        this.searchCondition = searchCondition;
    }

    public TableName getTableName() {
        return tableName;
    }

    public SearchCondition getSearchCondition() {
        return searchCondition;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
