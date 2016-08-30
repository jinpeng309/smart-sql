package com.capslock.sql.element;

import com.capslock.sql.Visitor;

import java.util.List;

/**
 * Created by capslock1874.
 */
public class QualifiedJoinTable extends JoinedTable {
    private final List<ColumnPair> columnPairs;

    public QualifiedJoinTable(final TableReference left, final TableReference right,
            final List<ColumnPair> columnPairs) {
        super(left, right);
        this.columnPairs = columnPairs;
    }

    public List<ColumnPair> getColumnPairs() {
        return columnPairs;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }

    public static class ColumnPair {
        private final ColumnName left;
        private final ColumnName right;

        public ColumnPair(final ColumnName left, final ColumnName right) {
            this.left = left;
            this.right = right;
        }

        public ColumnName getLeft() {
            return left;
        }

        public ColumnName getRight() {
            return right;
        }
    }
}
