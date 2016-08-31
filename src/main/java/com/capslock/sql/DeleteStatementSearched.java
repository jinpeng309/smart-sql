package com.capslock.sql;

import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.TableName;
import com.capslock.sql.element.TableReference;

/**
 * Created by capslock1874.
 */
public class DeleteStatementSearched implements Visitable {
    private final TableReference tableName;
    private final SearchCondition searchCondition;

    public DeleteStatementSearched(final TableReference tableName, final SearchCondition searchCondition) {
        this.tableName = tableName;
        this.searchCondition = searchCondition;
    }

    public TableReference getTableName() {
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
