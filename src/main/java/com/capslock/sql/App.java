package com.capslock.sql;

import com.capslock.sql.element.ColumnName;

import static com.capslock.sql.Sql.delete;
import static com.capslock.sql.Sql.table;

/**
 * Created by capslock1874.
 */
public class App {
    public static void main(String[] args) {
        final ColumnName name = new ColumnName("name");
        System.out.println(delete(table("Student")).where(name.eq("testName")).toSql());
    }
}
