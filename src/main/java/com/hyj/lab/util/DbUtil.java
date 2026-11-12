package com.hyj.lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC 连接工具类：驱动、URL、用户名、密码全部来自 db.properties。
 */
public class DbUtil {

    static {
        try {
            Class.forName(ConfigUtil.getDriver());
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("驱动加载失败，请检查 Maven 是否已引入 mysql-connector-j");
        }
    }

    private DbUtil() {
    }

    /**
     * @return 数据库连接
     * @throws SQLException 连接失败
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                ConfigUtil.getUrl(),
                ConfigUtil.getUserName(),
                ConfigUtil.getPassword());
    }
}
