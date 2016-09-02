package com.capslock.sql.element;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by capslock1874.
 */
public class OrderByClause implements Visitable{
    private List<SortSpecification> sortSpecifications = new ArrayList<>();

    public OrderByClause(){

    }

    public OrderByClause(final List<SortSpecification> sortSpecifications) {
        this.sortSpecifications.addAll(sortSpecifications);
    }

    public void addSpecification(final SortSpecification sortSpecification) {
        sortSpecifications.add(sortSpecification);
    }

    public List<SortSpecification> getSortSpecifications() {
        return sortSpecifications;
    }

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
