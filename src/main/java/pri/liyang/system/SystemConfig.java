package pri.liyang.system;

import java.io.*;
import java.util.Properties;

/**
 * 系统配置的处理类
 */
public class SystemConfig {

    /**
     * 系统配置类
     */
    public static Properties systemProperties = new Properties();

    /**
     * 初始化加载系统配置
     */
    static{
        try {
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in = new FileInputStream(new File("src\\main\\resources\\database.properties"));

            // 使用properties对象加载输入流
            systemProperties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取系统配置的值
     * @param key 系统配置key
     * @return 配置值
     */
    public static String getSystemProperty(String key){
        return systemProperties.getProperty(key);
    }

}
