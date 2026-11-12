package com.hyj.lab;

import org.apache.log4j.Logger;

import com.hyj.lab.util.DbUtil;
import com.hyj.lab.util.ConfigUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实验二 示例程序：用 Maven 构建、由 Maven 管理 JDBC / JUnit / log4j 依赖。
 *
 * 程序功能：读取 db.properties 里的连接参数，连接 MySQL 的 student_db，
 * 查询并打印 student 表中的学生信息，全过程用 log4j 输出日志。
 */
public class App {

    /** log4j 日志对象 */
    private static final Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("程序开始运行");
        LOG.info("驱动类：" + ConfigUtil.getDriver());
        LOG.info("连接串：" + ConfigUtil.getUrl());

        String sql = "SELECT student_id, student_name, gender, age, major FROM student ORDER BY student_id";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int count = 0;
            while (rs.next()) {
                count++;
                String line = String.format("学生{学号=%s, 姓名=%s, 性别=%s, 年龄=%d, 专业=%s}",
                        rs.getString("student_id"),
                        rs.getString("student_name"),
                        rs.getString("gender"),
                        rs.getInt("age"),
                        rs.getString("major"));
                LOG.info(line);
            }
            LOG.info("查询完成，共 " + count + " 条记录");
        } catch (SQLException e) {
            LOG.error("数据库操作失败：" + e.getMessage(), e);
        }
        LOG.info("程序结束");
    }
}
