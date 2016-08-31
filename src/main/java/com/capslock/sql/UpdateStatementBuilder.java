package com.capslock.sql;

import com.capslock.sql.element.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by capslock1874.
 */
public class UpdateStatementBuilder {
    private final TableReference tableName;
    private SearchCondition condition;
    private final List<SetClause> setClauseList = new ArrayList<>();

    public UpdateStatementBuilder(final TableReference tableName) {
        this.tableName = tableName;
    }

    public TableReference getTableName() {
        return tableName;
    }

    public void setCondition(final SearchCondition condition) {
        this.condition = condition;
    }

    public SearchCondition getCondition() {
        return condition;
    }


    public UpdateStatementBuilder set(final ColumnName columnName, final Express value) {
        setClauseList.add(new SetClause(columnName, value));
        return this;
    }

    public UpdateStatementSearched build() {
        final UpdateStatementSearched updateStatementSearched = new UpdateStatementSearched(tableName, setClauseList);
        updateStatementSearched.setCondition(condition);
        return updateStatementSearched;
    }

    public String toSql(){
        final Visitor visitor = new Visitor(new StringBuilder());
        visitor.visit(build());
        return visitor.toSql();
    }

}
