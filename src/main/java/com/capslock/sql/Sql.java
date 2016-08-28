package com.capslock.sql;

import com.capslock.sql.element.TableName;

/**
 * Created by capslock1874.
 */
public class Sql {
    public DeleteStatementBuilder delete(final TableName tableName){
        return new DeleteStatementBuilder(tableName);
    }
}
