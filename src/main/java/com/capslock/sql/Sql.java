package com.capslock.sql;

import com.capslock.sql.element.ColumnName;
import com.capslock.sql.element.Express;
import com.capslock.sql.element.Factor;
import com.capslock.sql.element.SelectList;
import com.capslock.sql.element.SelectSubList;
import com.capslock.sql.element.TableName;
import com.capslock.sql.element.TableReference;
import com.capslock.sql.element.Term;
import com.capslock.sql.element.UserDefinedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by capslock1874.
 */
public class Sql {
    public static DeleteStatementBuilder delete(final TableReference tableName) {
        return new DeleteStatementBuilder(tableName);
    }

    public static UpdateStatementBuilder update(final TableReference tableName) {
        return new UpdateStatementBuilder(tableName);
    }

    public static SelectStatementBuilder select(final ColumnName... columnNames) {
        final List<SelectSubList> subList = new ArrayList<>();
        for (final ColumnName columnName : columnNames) {
            subList.add(new SelectSubList(convertColumnNameToTerm(columnName)));
        }
        final SelectList selectList = new SelectList(subList);
        return new SelectStatementBuilder(selectList);
    }

    public static InsertStatementBuilder insertInto(final TableReference tableReference) {
        return new InsertStatementBuilder(tableReference.getPrimaryTable());
    }

    public static InsertStatementBuilder insertIgnoreInto(final TableReference tableReference) {
        return new InsertStatementBuilder(tableReference.getPrimaryTable(), true, false);
    }

    public static InsertStatementBuilder insertReplaceInto(final TableReference tableReference) {
        return new InsertStatementBuilder(tableReference.getPrimaryTable(), false, true);
    }

    public static Term convertColumnNameToTerm(final ColumnName columnName) {
        return new Term(new Factor(columnName));
    }

    public static TableReference table(final String name) {
        return new TableReference(new TableName(new UserDefinedName(name)));
    }

    public static ColumnName column(final String name) {
        return new ColumnName(name);
    }

    public static Express stringExpress(final String value) {
        return new Express(value);
    }

    public static <T extends Number> Express number(final T value) {
        return new Express(value.toString());
    }
}
