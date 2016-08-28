package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

/**
 * Created by capslock1874.
 */
public class BooleanPrimary implements Visitable{
    private ComparisonPredicate comparisonPredicate;
    private SearchCondition searchCondition;

    public BooleanPrimary(){}
    public BooleanPrimary(final ComparisonPredicate comparisonPredicate) {
        this.comparisonPredicate = comparisonPredicate;
    }

    public ComparisonPredicate getComparisonPredicate() {
        return comparisonPredicate;
    }

    public void setComparisonPredicate(final ComparisonPredicate comparisonPredicate) {
        this.comparisonPredicate = comparisonPredicate;
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
