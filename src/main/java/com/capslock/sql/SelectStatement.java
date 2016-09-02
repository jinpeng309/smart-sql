package com.capslock.sql;

import com.capslock.sql.Visitable;
import com.capslock.sql.Visitor;
import com.capslock.sql.element.OrderByClause;
import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.SelectList;
import com.capslock.sql.element.TableReferenceList;

/**
 * Created by capslock1874.
 */
public class SelectStatement implements Visitable{
    private final SelectList selectList;
    private final TableReferenceList tableReferenceList;
    private final SearchCondition searchCondition;
    private final OrderByClause orderByClause;

    public SelectStatement(final SelectList selectList, final TableReferenceList tableReferenceList, final SearchCondition searchCondition, final OrderByClause orderByClause) {
        this.selectList = selectList;
        this.tableReferenceList = tableReferenceList;
        this.searchCondition = searchCondition;
        this.orderByClause = orderByClause;
    }

    public OrderByClause getOrderByClause() {
        return orderByClause;
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

    @Override
    public void visit(final Visitor visitor) {
        visitor.visit(this);
    }
}
