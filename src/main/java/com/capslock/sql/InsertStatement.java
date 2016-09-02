package com.capslock.sql;

import com.capslock.sql.element.ColumnIdentifier;
import com.capslock.sql.element.InsertValue;
import com.capslock.sql.element.TableName;

import java.util.List;

/**
 * Created by capslock1874.
 */
public class InsertStatement implements Visitable{
    private final TableName tableName;
    private final boolean isIgnore;
    private final boolean isReplace;
    private final List<ColumnValuePair> pairs;

    public InsertStatement(final TableName tableName, final boolean isIgnore, final boolean isReplace, final List<ColumnValuePair> pairs) {
        this.tableName = tableName;
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

    public TableName getTableName() {
        return tableName;
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
