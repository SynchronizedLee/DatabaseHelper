package pri.liyang.handler;

import pri.liyang.interfaces.ConnectHandler;
import pri.liyang.system.SystemConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySQL的连接处理类
 */
public class MySQLConnectHandler implements ConnectHandler {

    /**
     * 单例Connection
     */
    private static Connection connection = null;

    /**
     * 初始化连接
     */
    static{
        try {
            //从配置文件获取数据库连接参数
            String driver = SystemConfig.getSystemProperty("driver");
            String url = SystemConfig.getSystemProperty("url");
            String username = SystemConfig.getSystemProperty("username");
            String password = SystemConfig.getSystemProperty("password");

            //注册Driver
            Class.forName(driver);

            //获取Connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return Connection
     */
    @Override
    public Connection getConnection(){
        return connection;
    }

}
