package pri.liyang.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库业务接口
 */
public interface DBService {

    List<String> getAllTableName() throws SQLException;

}
