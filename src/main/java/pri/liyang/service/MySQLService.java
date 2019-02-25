package pri.liyang.service;

import pri.liyang.entity.FieldInfo;
import pri.liyang.executor.MySQLExecutor;
import pri.liyang.interfaces.DBExecutor;
import pri.liyang.interfaces.DBService;
import pri.liyang.system.SystemConfig;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MySQLService implements DBService {

    /**
     * 获取数据库所有表名的SQL
     */
    private final String TABLE_NAME_SQL = "select table_name from information_schema.tables WHERE table_schema = ? ";

    /**
     * 获取表的结构信息的SQL
     */
    private final String TABLE_FIELD_INFO_SQL = "SELECT * FROM information_schema.`COLUMNS` " +
            "WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?";

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
     * 根据表名，获取该表的表结构信息
     * @param tableName 表名
     * @return
     * @throws SQLException
     */
    @Override
    public List<FieldInfo> getFieldInfoListByTableName(String tableName) throws SQLException {
        //获取所有表名数据
        List<Map<String, Object>> data = dbExecutor.executeQuery(TABLE_FIELD_INFO_SQL, new Object[]{getDBName(), tableName});

        //FieldInfo的List集合
        List<FieldInfo> fieldInfoList = new ArrayList<>();

        //转化为FieldInfo对象
        for (Map<String, Object> map : data){
            FieldInfo fieldInfo = new FieldInfo();

            fieldInfo.setDbName((String) map.get("TABLE_SCHEMA"));
            fieldInfo.setTableName((String) map.get("TABLE_NAME"));
            fieldInfo.setColumnName((String) map.get("COLUMN_NAME"));
            fieldInfo.setColumnDefault((String) map.get("COLUMN_DEFAULT"));
            fieldInfo.setIsNullAble((String) map.get("IS_NULLABLE"));
            fieldInfo.setDataType((String) map.get("DATA_TYPE"));
            fieldInfo.setCharacterMaximumLength((String) map.get("CHARACTER_MAXIMUM_LENGTH"));
            fieldInfo.setCharacterOctetLength((String) map.get("CHARACTER_OCTET_LENGTH"));
            fieldInfo.setNumericPrecision((String) map.get("NUMERIC_PRECISION"));
            fieldInfo.setNumericPrecision((String) map.get("NUMERIC_SCALE"));
            fieldInfo.setCharacterSetName((String) map.get("CHARACTER_SET_NAME"));
            fieldInfo.setCollationName((String) map.get("COLLATION_NAME"));
            fieldInfo.setColumnType((String) map.get("COLUMN_TYPE"));
            fieldInfo.setColumnKey((String) map.get("COLUMN_KEY"));
            fieldInfo.setExtra((String) map.get("EXTRA"));
            fieldInfo.setPrivileges((String) map.get("PRIVILEGES"));
            fieldInfo.setColumnComment((String) map.get("COLUMN_COMMENT"));

            fieldInfoList.add(fieldInfo);
        }

        return fieldInfoList;
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
