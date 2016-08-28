package com.capslock.sql;

import com.capslock.sql.element.ColumnName;

import static com.capslock.sql.Sql.delete;
import static com.capslock.sql.Sql.table;

/**
 * Created by capslock1874.
 */
public class App {
    public static void main(String[] args) {
        final ColumnName name = new ColumnName("Student.name");
        final ColumnName id = new ColumnName("id");
        final ColumnName address = new ColumnName("address");
        final ColumnName email = new ColumnName("email");
        final String sql = delete(table("Student"))
                .where(name.eq("testName").and(id.eq("1"))
                        .or(address.eq("home")
                                .and(email.eq("a@qq.com"))))
                .toSql();
        System.out.println(sql);
    }
}
