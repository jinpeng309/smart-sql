package com.capslock.sql.element;

/**
 * Created by capslock1874.
 */
public class SelectStatement {
    private final SelectList selectList;
    private final TableReferenceList tableReferenceList;
    private final SearchCondition searchCondition;

    public SelectStatement(final SelectList selectList, final TableReferenceList tableReferenceList,
            final SearchCondition searchCondition) {
        this.selectList = selectList;
        this.tableReferenceList = tableReferenceList;
        this.searchCondition = searchCondition;
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
