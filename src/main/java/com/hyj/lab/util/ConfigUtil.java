package com.hyj.lab.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件访问类：读取 classpath 下的 db.properties。
 */
public class ConfigUtil {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (in == null) {
                throw new IllegalStateException("未找到 db.properties");
            }
            PROPS.load(in);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("配置文件读取失败：" + e.getMessage());
        }
    }

    private ConfigUtil() {
    }

    public static String getDriver() {
        return PROPS.getProperty("jdbc.driver");
    }

    public static String getUrl() {
        return PROPS.getProperty("jdbc.url");
    }

    public static String getUserName() {
        return PROPS.getProperty("jdbc.username");
    }

    public static String getPassword() {
        return PROPS.getProperty("jdbc.password");
    }
}
