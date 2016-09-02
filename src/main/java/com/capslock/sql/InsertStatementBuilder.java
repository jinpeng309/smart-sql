package com.capslock.sql;

import com.capslock.sql.element.ColumnIdentifier;
import com.capslock.sql.element.ColumnName;
import com.capslock.sql.element.Express;
import com.capslock.sql.element.InsertValue;
import com.capslock.sql.element.TableReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by capslock1874.
 */
public class InsertStatementBuilder {
    private final TableReference tableReference;
    private boolean isIgnore = false;
    private boolean isReplace = false;
    private List<InsertStatement.ColumnValuePair> pairs = new ArrayList<>();

    public InsertStatementBuilder(final TableReference tableReference) {
        this.tableReference = tableReference;
    }

    public InsertStatementBuilder(final TableReference tableReference, final boolean isIgnore, final boolean isReplace) {
        this.tableReference = tableReference;
        this.isIgnore = isIgnore;
        this.isReplace = isReplace;
    }

    public InsertStatementBuilder value(final ColumnName columnName, final InsertValue insertValue) {
        pairs.add(new InsertStatement.ColumnValuePair(columnName.getColumnIdentifier(), insertValue));
        return this;
    }

    public InsertStatementBuilder value(final ColumnIdentifier columnIdentifier, final InsertValue insertValue) {
        pairs.add(new InsertStatement.ColumnValuePair(columnIdentifier, insertValue));
        return this;
    }

    public InsertStatementBuilder value(final ColumnName columnName, final Express express) {
        return value(columnName, new InsertValue(express.getTerm().getFactor().getLiteral()));
    }

    public TableReference getTableReference() {
        return tableReference;
    }

    public boolean isIgnore() {
        return isIgnore;
    }

    public boolean isReplace() {
        return isReplace;
    }

    public List<InsertStatement.ColumnValuePair> getPairs() {
        return pairs;
    }

    public InsertStatement build() {
        return new InsertStatement(getTableReference(), isIgnore(), isReplace(), getPairs());
    }

    public String toSql() {
        final Visitor visitor = new Visitor(new StringBuilder());
        visitor.visit(build());
        return visitor.toSql();
    }

}
