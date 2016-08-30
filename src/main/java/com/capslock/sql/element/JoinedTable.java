package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;
import com.google.common.collect.Lists;

/**
 * Created by capslock1874.
 */
public class JoinedTable implements Visitable {
    private final TableReference left;
    private final TableReference right;

    public JoinedTable(final TableReference left, final TableReference right) {
        this.left = left;
        this.right = right;
    }

    public TableReference getLeft() {
        return left;
    }

    public TableReference getRight() {
        return right;
    }

    public QualifiedJoinTable on(final ColumnName left, final ColumnName right) {
        return new QualifiedJoinTable(getLeft(), getRight(), Lists.newArrayList(generateColumnPair(left, right)));
    }

    private QualifiedJoinTable.ColumnPair generateColumnPair(final ColumnName left, final ColumnName right) {
        return new QualifiedJoinTable.ColumnPair(left, right);
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
