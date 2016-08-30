package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class TableReference implements Visitable {
    private TableName name;
    private JoinedTable joinedTable;

    public TableReference(final TableName name) {
        this.name = name;
    }

    public TableReference(final JoinedTable joinedTable) {
        this.joinedTable = joinedTable;
    }

    public void setJoinedTable(final JoinedTable joinedTable) {
        this.joinedTable = joinedTable;
    }

    public void setPrimaryTable(final TableName name) {
        this.name = name;
    }

    public JoinedTable getJoinedTable() {
        return joinedTable;
    }

    public TableName getPrimaryTable() {
        return name;
    }

    public JoinedTable join(final TableReference tableReference) {
        return new JoinedTable(this, tableReference);
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
