package com.capslock.sql;

import com.capslock.sql.element.BooleanTerm;
import com.capslock.sql.element.ColumnName;
import com.capslock.sql.element.ComparisonPredicate;
import com.capslock.sql.element.Order;
import com.capslock.sql.element.OrderByClause;
import com.capslock.sql.element.QualifiedJoinTable;
import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.SelectList;
import com.capslock.sql.element.SortSpecification;
import com.capslock.sql.element.TableReference;
import com.capslock.sql.element.TableReferenceList;

/**
 * Created by capslock1874.
 */
public class SelectStatementBuilder {
    private SelectList selectList;
    private TableReferenceList tableReferenceList;
    private SearchCondition searchCondition;
    private OrderByClause orderByClause;

    public SelectStatementBuilder(final SelectList selectList) {
        this.selectList = selectList;
    }

    public SelectStatementBuilder from(final TableReferenceList tableReferenceList) {
        this.tableReferenceList = tableReferenceList;
        return this;
    }

    public SelectStatementBuilder from(final TableReference tableReference) {
        return from(new TableReferenceList().addReference(tableReference));
    }

    public SelectStatementBuilder from(final QualifiedJoinTable table) {
        return from(new TableReferenceList().addReference(new TableReference(table)));
    }

    public SelectStatementBuilder where(final SearchCondition searchCondition) {
        this.searchCondition = searchCondition;
        return this;
    }

    public SelectStatementBuilder where(final ComparisonPredicate comparisonPredicate) {
        return where(new SearchCondition(new BooleanTerm(comparisonPredicate)));
    }

    public SelectStatementBuilder orderBy(final ColumnName columnName){
        return orderBy(new SortSpecification().setColumnName(columnName));
    }

    public SelectStatementBuilder orderBy(final ColumnName columnName, final Order order){
        return orderBy(new SortSpecification().setColumnName(columnName).setOrder(order));
    }

    public SelectStatementBuilder orderBy(final SortSpecification sortSpecification) {
        if (orderByClause == null) {
            orderByClause = new OrderByClause();
        }
        orderByClause.addSpecification(sortSpecification);
        return this;
    }

    public SelectStatementBuilder orderBy(final SortSpecification sortSpecification, final Order order) {
        if (orderByClause == null) {
            orderByClause = new OrderByClause();
        }
        sortSpecification.setOrder(order);
        orderByClause.addSpecification(sortSpecification);
        return this;
    }

    public SelectList getSelectList() {
        return selectList;
    }

    public TableReferenceList getTableReferenceList() {
        return tableReferenceList;
    }

    public SearchCondition getSearchCondition() {
        return searchCondition;
    }

    public OrderByClause getOrderByClause() {
        return orderByClause;
    }

    public SelectStatement build() {
        return new SelectStatement(getSelectList(), getTableReferenceList(), getSearchCondition(), getOrderByClause());
    }

    public String toSql() {
        final Visitor visitor = new Visitor(new StringBuilder());
        visitor.visit(build());
        return visitor.toSql();
    }

    public SelectStatementBuilder where(final BooleanTerm condition) {
        return where(new SearchCondition(condition));
    }

}
