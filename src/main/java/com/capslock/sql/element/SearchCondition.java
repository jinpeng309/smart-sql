package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */

// search-condition ::= boolean-term [OR search-condition]
public class SearchCondition implements Visitable{
    private final BooleanTerm term;
    private SearchCondition searchCondition;

    public SearchCondition(final BooleanTerm term) {
        this.term = term;
    }

    public BooleanTerm getTerm() {
        return term;
    }

    public SearchCondition getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(final SearchCondition searchCondition) {
        this.searchCondition = searchCondition;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
