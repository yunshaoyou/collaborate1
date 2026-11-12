package com.hyj.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.hyj.lab.util.ConfigUtil;

/**
 * 单元测试类：放在 src/test/java 下，由 Maven 的 surefire 插件自动执行。
 * 这里只校验配置文件能否被正确读取，不依赖数据库。
 */
public class AppTest {

    @Test
    public void testDriverConfig() {
        assertEquals("com.mysql.cj.jdbc.Driver", ConfigUtil.getDriver());
    }

    @Test
    public void testUrlConfig() {
        assertNotNull(ConfigUtil.getUrl());
        assertEquals(true, ConfigUtil.getUrl().contains("student_db"));
    }
}
