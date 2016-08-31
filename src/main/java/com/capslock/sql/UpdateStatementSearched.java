package com.capslock.sql;

import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.SetClause;
import com.capslock.sql.element.TableReference;

import java.util.List;

/**
 * Created by capslock1874.
 */
public class UpdateStatementSearched implements Visitable {
    private final TableReference tableName;
    private SearchCondition condition;
    private final List<SetClause> setClauses;

    public UpdateStatementSearched(final TableReference tableName, final List<SetClause> setClauses) {
        this.tableName = tableName;
        this.setClauses = setClauses;
    }

    public List<SetClause> getSetClauses() {
        return setClauses;
    }

    public void setCondition(final SearchCondition condition) {
        this.condition = condition;
    }

    public TableReference getTableName() {
        return tableName;
    }

    public SearchCondition getCondition() {
        return condition;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
