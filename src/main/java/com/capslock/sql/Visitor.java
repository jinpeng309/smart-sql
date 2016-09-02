package com.capslock.sql;

import com.capslock.sql.element.BinaryOperator;
import com.capslock.sql.element.BooleanFactor;
import com.capslock.sql.element.BooleanPrimary;
import com.capslock.sql.element.BooleanTerm;
import com.capslock.sql.element.ColumnIdentifier;
import com.capslock.sql.element.ColumnName;
import com.capslock.sql.element.ComparisonPredicate;
import com.capslock.sql.element.Express;
import com.capslock.sql.element.Factor;
import com.capslock.sql.element.InsertValue;
import com.capslock.sql.element.JoinedTable;
import com.capslock.sql.element.Literal;
import com.capslock.sql.element.OrderByClause;
import com.capslock.sql.element.QualifiedJoinTable;
import com.capslock.sql.element.SearchCondition;
import com.capslock.sql.element.SelectList;
import com.capslock.sql.element.SelectStatement;
import com.capslock.sql.element.SelectSubList;
import com.capslock.sql.element.SetClause;
import com.capslock.sql.element.SortSpecification;
import com.capslock.sql.element.TableIdentifier;
import com.capslock.sql.element.TableName;
import com.capslock.sql.element.TableReference;
import com.capslock.sql.element.TableReferenceList;
import com.capslock.sql.element.Term;
import com.capslock.sql.element.UnaryOperator;
import com.capslock.sql.element.UserDefinedName;

import java.util.List;

/**
 * Created by capslock1874.
 */
public class Visitor {
    private final StringBuilder builder;

    public Visitor(final StringBuilder builder) {
        this.builder = builder;
    }

    private void append(final String data) {
        builder.append(data);
    }

    private void appendSpace() {
        builder.append(" ");
    }

    public void visit(final Express express) {
        if (express.getExpress() != null) {
            visit(express.getExpress());
            appendSpace();
            visit(express.getBinaryOperator());
            appendSpace();
            visit(express.getTerm());
        } else {
            visit(express.getTerm());
        }
    }

    public void visit(final Factor factor) {
        if (factor.getOperator() != null) {
            visit(factor.getOperator());
        } else if (factor.getLiteral() != null) {
            visit(factor.getLiteral());
        } else if (factor.getColumnName() != null) {
            visit(factor.getColumnName());
        } else {
            append("(");
            visit(factor.getExpress());
            append(")");
        }
    }

    public void visit(final UnaryOperator unaryOperator) {
        append(unaryOperator.getOperator());
    }

    public void visit(final Term term) {
        if (term.getOperator() != null) {
            visit(term.getAnotherTerm());
            appendSpace();
            visit(term.getOperator());
            appendSpace();
            visit(term.getFactor());
        } else {
            visit(term.getFactor());
        }
    }

    public void visit(final Literal literal) {
        appendSpace();
        append("'");
        append(literal.getData());
        append("'");
    }

    public String toSql() {
        return builder.toString();
    }

    public void visit(final BinaryOperator binaryOperator) {
        append(binaryOperator.getOperator());
    }

    public void visit(final BooleanFactor booleanFactor) {
        if (booleanFactor.isHasNot()) {
            appendSpace();
            append("NOT");
            visit(booleanFactor.getPrimary());
        } else {
            visit(booleanFactor.getPrimary());
        }
    }

    public void visit(final BooleanPrimary primary) {
        if (primary.getComparisonPredicate() != null) {
            visit(primary.getComparisonPredicate());
        } else {
            visit(primary.getSearchCondition());
        }
    }

    public void visit(final SearchCondition searchCondition) {
        visit(searchCondition.getTerm());
        if (searchCondition.getSearchCondition() != null) {
            append(" OR");
            visit(searchCondition.getSearchCondition());
        }
    }

    public void visit(final ComparisonPredicate comparisonPredicate) {
        visit(comparisonPredicate.getLeftExpress());
        visit(comparisonPredicate.getBinaryOperator());
        visit(comparisonPredicate.getRightExpress());
    }

    public void visit(final BooleanTerm booleanTerm) {
        appendSpace();
        append("(");
        visit(booleanTerm.getFactor());
        if (booleanTerm.getTerm() != null) {
            append(" AND ");
            visit(booleanTerm.getTerm());
        }
        append(")");
    }

    public void visit(final ColumnIdentifier columnIdentifier) {
        visit(columnIdentifier.getName());
    }

    public void visit(final UserDefinedName name) {
        appendSpace();
        append(name.getName());
    }

    public void visit(final ColumnName columnName) {
        if (columnName.getTableName() != null) {
            visit(columnName.getTableName());
            append(".");
        }
        append(columnName.getColumnIdentifier().getName().getName());
        if (columnName.getAliasName() != null) {
            append(" AS");
            visit(columnName.getAliasName());
        }
    }

    public void visit(final TableName tableName) {
        visit(tableName.getName());
    }

    public void visit(final OrderByClause orderByClause) {
        appendSpace();
        append("ORDER BY");
        for (int i = 0; i < orderByClause.getSortSpecifications().size(); i++) {
            final SortSpecification sortSpecification = orderByClause.getSortSpecifications().get(i);
            visit(sortSpecification);
            if (i != orderByClause.getSortSpecifications().size() - 1) {
                append(",");
            }
        }
    }

    public void visit(final SortSpecification sortSpecification) {
        if (sortSpecification.getColumnIndex() >= 0) {
            append(Integer.toString(sortSpecification.getColumnIndex()));
        } else {
            visit(sortSpecification.getColumnName());
        }
    }

    public void visit(final SelectList selectList) {
        final List<SelectSubList> selectSubLists = selectList.getSelectSubLists();
        for (int i = 0; i < selectSubLists.size(); i++) {
            final SelectSubList subList = selectSubLists.get(i);
            visit(subList);
            if (i != selectSubLists.size() - 1) {
                append(", ");
            }
        }
    }

    public void visit(final TableIdentifier tableIdentifier) {
        visit(tableIdentifier.getName());
    }

    public void visit(final TableReference tableReference) {
        if (tableReference.getPrimaryTable() != null) {
            visit(tableReference.getPrimaryTable());
        } else {
            if (tableReference.getJoinedTable() instanceof QualifiedJoinTable) {
                visit((QualifiedJoinTable) tableReference.getJoinedTable());
            } else {
                visit(tableReference.getJoinedTable());
            }
        }
    }

    public void visit(final TableReferenceList tableReferenceList) {
        for (int i = 0; i < tableReferenceList.getReferenceList().size(); i++) {
            final TableReference reference = tableReferenceList.getReferenceList().get(i);
            visit(reference);
            if (i != tableReferenceList.getReferenceList().size() - 1) {
                append(",");
            }
        }
    }

    public void visit(final DeleteStatementSearched deleteStatementSearched) {
        append("DELETE FROM");
        visit(deleteStatementSearched.getTableName());
        appendSpace();
        append("WHERE");
        visit(deleteStatementSearched.getSearchCondition());
    }

    public void visit(final UpdateStatementSearched updateStatementSearched) {
        append("UPDATE");
        visit(updateStatementSearched.getTableName());
        append(" SET");
        for (int i = 0; i < updateStatementSearched.getSetClauses().size(); i++) {
            visit(updateStatementSearched.getSetClauses().get(i));
            if (i != updateStatementSearched.getSetClauses().size() - 1) {
                append(",");
            }
        }
        if (updateStatementSearched.getCondition() != null) {
            append("WHERE ");
            visit(updateStatementSearched.getCondition());
        }
    }

    public void visit(final SetClause setClause) {
        visit(setClause.getColumnName());
        visit(BinaryOperator.EQ);
        visit(setClause.getExpress());
    }

    public void visit(final QualifiedJoinTable table) {
        visit(table.getLeft());
        append(" JOIN");
        visit(table.getRight());
        append(" ON");
        final List<QualifiedJoinTable.ColumnPair> columnPairs = table.getColumnPairs();
        visit(columnPairs);
    }

    private void visit(final List<QualifiedJoinTable.ColumnPair> columnPairs) {
        for (int i = 0; i < columnPairs.size(); i++) {
            final QualifiedJoinTable.ColumnPair columnPair = columnPairs.get(i);
            appendSpace();
            visit(columnPair.getLeft());
            append(" =");
            appendSpace();
            visit(columnPair.getRight());
            if (i != columnPairs.size() - 1) {
                append(",");
            }
        }
    }

    public void visit(final JoinedTable joinedTable) {
        visit(joinedTable.getLeft());
        append(" join");
        visit(joinedTable.getRight());
    }

    public void visit(final SelectStatement build) {
        append("SELECT");
        visit(build.getSelectList());
        append(" FROM");
        visit(build.getTableReferenceList());
        if (build.getSearchCondition() != null) {
            append(" WHERE");
            visit(build.getSearchCondition());
        }
    }

    public void visit(final InsertValue insertValue) {
        if (insertValue.isNull()) {
            append(" NULL");
        } else {
            visit(insertValue.getLiteral());
        }
    }

    public void visit(final InsertStatement insertStatement) {
        if (insertStatement.isIgnore()) {
            append("INSERT OR IGNORE INTO");
        } else if (insertStatement.isReplace()) {
            append("INSERT OR REPLACE INTO");
        } else {
            append("INSERT INTO");
        }
        visit(insertStatement.getTableReference());
        List<InsertStatement.ColumnValuePair> pairs = insertStatement.getPairs();
        append(" (");
        for (int i = 0; i < pairs.size(); i++) {
            visit(pairs.get(i).getColumn());
            if (i != pairs.size() - 1) {
                append(",");
            }
        }
        append(")");
        append(" VALUES");
        appendSpace();
        append("(");
        for (int i = 0; i < pairs.size(); i++) {
            visit(pairs.get(i).getValue());
            if (i != pairs.size() - 1) {
                append(",");
            }
        }
        append(")");
    }
}
