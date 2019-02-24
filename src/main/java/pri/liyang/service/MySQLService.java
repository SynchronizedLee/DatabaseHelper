package pri.liyang.service;

import pri.liyang.executor.MySQLExecutor;
import pri.liyang.interfaces.DBExecutor;
import pri.liyang.interfaces.DBService;
import pri.liyang.system.SystemConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MySQLService implements DBService {

    /**
     * 获取数据库所有表名的SQL
     */
    private final String TABLE_NAME_SQL = "select table_name from information_schema.tables WHERE table_schema = ?";

    /**
     * 数据库执行类
     */
    private DBExecutor dbExecutor = new MySQLExecutor();

    /**
     * 获取当前数据库所有的表名
     * @return List<String>表名集合
     * @throws SQLException
     */
    @Override
    public List<String> getAllTableName() throws SQLException {
        //获取所有表名数据
        List<Map<String, Object>> data = dbExecutor.executeQuery(TABLE_NAME_SQL, new Object[]{getDBName()});

        //表名List
        List<String> tableNameList = new ArrayList<>();

        //遍历获取表名集合
        for (Map<String, Object> map : data){
            String table_name = (String) map.get("TABLE_NAME");
            tableNameList.add(table_name);
        }

        return tableNameList;
    }

    /**
     * 根据配置文件的url，获得数据库名
     * @return
     */
    private static String getDBName(){
        //获得url
        String url = SystemConfig.getSystemProperty("url");

        //经过两步处理，获得dbName
        String dbName = url.substring(0, url.indexOf("?"));
        dbName = url.substring(dbName.lastIndexOf("/") + 1, dbName.length());

        return dbName;
    }

}
