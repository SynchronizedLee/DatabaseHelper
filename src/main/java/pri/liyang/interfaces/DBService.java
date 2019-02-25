package pri.liyang.interfaces;

import pri.liyang.entity.FieldInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 数据库业务接口
 */
public interface DBService {

    /**
     * 获取当前数据库的全部表名
     * @return List<String>表名
     * @throws SQLException
     */
    List<String> getAllTableName() throws SQLException;

    /**
     * 根据表名，获取该表的表结构信息
     * @param tableName
     * @return
     * @throws SQLException
     */
    List getFieldInfoListByTableName(String tableName) throws SQLException;

}
