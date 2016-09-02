package com.capslock.sql;

import com.capslock.sql.element.ColumnIdentifier;
import com.capslock.sql.element.InsertValue;
import com.capslock.sql.element.TableReference;

import java.util.List;

/**
 * Created by capslock1874.
 */
public class InsertStatement implements Visitable{
    private final TableReference tableReference;
    private final boolean isIgnore;
    private final boolean isReplace;
    private final List<ColumnValuePair> pairs;

    public InsertStatement(final TableReference tableReference, final boolean isIgnore, final boolean isReplace, final List<ColumnValuePair> pairs) {
        this.tableReference = tableReference;
        this.isIgnore = isIgnore;
        this.isReplace = isReplace;
        this.pairs = pairs;
    }

    public boolean isIgnore() {
        return isIgnore;
    }

    public boolean isReplace() {
        return isReplace;
    }

    public List<ColumnValuePair> getPairs() {
        return pairs;
    }

    public TableReference getTableReference() {
        return tableReference;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }

    public static class ColumnValuePair {
        private final ColumnIdentifier column;
        private final InsertValue value;

        public ColumnValuePair(final ColumnIdentifier column, final InsertValue value) {
            this.column = column;
            this.value = value;
        }

        public ColumnIdentifier getColumn() {
            return column;
        }

        public InsertValue getValue() {
            return value;
        }
    }
}
