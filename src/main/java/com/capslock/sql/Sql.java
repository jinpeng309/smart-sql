package com.capslock.sql;

import com.capslock.sql.element.Express;
import com.capslock.sql.element.TableName;
import com.capslock.sql.element.TableReference;
import com.capslock.sql.element.UserDefinedName;

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

    public static TableReference table(final String name) {
        return new TableReference(new TableName(new UserDefinedName(name)));
    }

    public static Express stringExpress(final String value) {
        return new Express(value);
    }
}
