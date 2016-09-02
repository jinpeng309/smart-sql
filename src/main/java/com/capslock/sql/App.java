package com.capslock.sql;

import com.capslock.sql.element.ColumnName;

import static com.capslock.sql.Sql.column;
import static com.capslock.sql.Sql.delete;
import static com.capslock.sql.Sql.insertInto;
import static com.capslock.sql.Sql.select;
import static com.capslock.sql.Sql.stringExpress;
import static com.capslock.sql.Sql.table;
import static com.capslock.sql.Sql.update;

/**
 * Created by capslock1874.
 */
public class App {
    public static void main(String[] args) {
        final ColumnName name = column("Student.name");
        final ColumnName id = column("id");
        final ColumnName address = column("address");
        final ColumnName email = column("email");
        final String sql = delete(table("Student"))
                .where(name.eq("testName").and(id.eq("1"))
                        .or(address.eq("home")
                                .and(email.eq("a@qq.com"))))
                .toSql();
        System.out.println(sql);
        final String updateSql = update(table("Student")).set(name, stringExpress("test")).set(email, stringExpress("824@qq.com")).toSql();
        System.out.println(updateSql);
        System.out.println(select(name, id).from(table("address").join(table("student")).on(id, id)).where(address.eq("address").and(name.eq("name"))).toSql());
        System.out.println(
                insertInto(table("student"))
                        .value(name, stringExpress("test"))
                        .value(address, stringExpress("address"))
                        .toSql()
        );
    }
}
