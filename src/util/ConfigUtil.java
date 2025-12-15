package util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    private static Properties props = new Properties();
    static {
        try (InputStream is = ConfigUtil.class.getClassLoader().getResourceAsStream("config/app.properties")) {
            if (is != null) {
                props.load(is);
            }
        } catch (Exception e) {
            // ignore, defaults used
        }
    }

    public static String get(String key, String def) {
        return props.getProperty(key, def);
    }
}
