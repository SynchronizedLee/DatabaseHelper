package pri.liyang.interfaces;

import java.sql.Connection;

/**
 * 数据库连接处理接口
 */
public interface ConnectHandler {

    /**
     * 获取数据库连接
     * @return
     */
    Connection getConnection();

}
