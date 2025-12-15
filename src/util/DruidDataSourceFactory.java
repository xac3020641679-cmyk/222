package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * 从 classpath 加载 druid.properties 并创建 DataSource。
 * 请确保你的项目 pom/gradle 中包含了 druid 依赖。
 */
public class DruidDataSourceFactory {
    private static DataSource dataSource;

    static {
        try {
            Properties props = new Properties();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties");
            if (is != null) {
                props.load(is);
                dataSource = DruidDataSourceFactory.createDataSource(props);
            } else {
                throw new RuntimeException("druid.properties not found in classpath");
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Failed to init Druid datasource: " + e.getMessage());
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
