package pri.liyang.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 数据路执行接口
 */
public interface DBExecutor{

    /**
     * 数据库执行更新
     * @param sql 执行的SQL
     * @return
     */
    Integer executeUpdate(String sql, Object[] param) throws SQLException;

    /**
     * 数据库执行查询
     * @param sql 执行的SQL
     * @return
     */
    List<Map<String, Object>> executeQuery(String sql, Object[] param) throws SQLException;

}
