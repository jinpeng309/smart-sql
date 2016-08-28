package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

import java.util.List;

/**
 * Created by capslock1874.
 */
public class SelectList implements Visitable{
    private final List<SelectSubList> selectSubLists;

    public SelectList(final List<SelectSubList> selectSubLists) {
        this.selectSubLists = selectSubLists;
    }

    public List<SelectSubList> getSelectSubLists() {
        return selectSubLists;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
