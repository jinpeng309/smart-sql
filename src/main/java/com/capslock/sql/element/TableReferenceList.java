package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by capslock1874.
 */
public class TableReferenceList implements Visitable {
    private final List<TableReference> referenceList = new ArrayList<>();

    public TableReferenceList() {
    }

    public List<TableReference> getReferenceList() {
        return referenceList;
    }

    public void addReference(final TableReference reference) {
        referenceList.add(reference);
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
