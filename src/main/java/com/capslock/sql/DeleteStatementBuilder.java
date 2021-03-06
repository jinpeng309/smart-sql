package com.capslock.sql;

import com.capslock.sql.element.*;

/**
 * Created by capslock1874.
 */
public class DeleteStatementBuilder {
    private final TableReference tableName;
    private SearchCondition condition;

    public DeleteStatementBuilder(final TableReference tableName) {
        this.tableName = tableName;
    }

    public SearchCondition getCondition() {
        return condition;
    }

    public TableReference getTableName() {
        return tableName;
    }

    public DeleteStatementBuilder where(final SearchCondition condition) {
        this.condition = condition;
        return this;
    }

    public DeleteStatementBuilder where(final ComparisonPredicate condition) {
        final BooleanPrimary booleanPrimary = new BooleanPrimary();
        booleanPrimary.setComparisonPredicate(condition);
        this.condition = new SearchCondition(new BooleanTerm(new BooleanFactor(booleanPrimary)));
        return this;
    }

    public DeleteStatementBuilder where(final BooleanTerm condition) {
        this.condition = new SearchCondition(condition);
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
