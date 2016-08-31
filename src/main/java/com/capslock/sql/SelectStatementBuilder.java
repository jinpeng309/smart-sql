package com.capslock.sql;

import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.SelectList;
import com.capslock.sql.element.TableReference;
import com.capslock.sql.element.TableReferenceList;

/**
 * Created by capslock1874.
 */
public class SelectStatementBuilder {
    private SelectList selectList;
    private TableReferenceList tableReferenceList;
    private SearchCondition searchCondition;

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

    public SelectStatementBuilder where(final SearchCondition searchCondition) {
        this.searchCondition = searchCondition;
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
}
