package pri.liyang.executor;

import pri.liyang.handler.MySQLConnectHandler;
import pri.liyang.interfaces.ConnectHandler;
import pri.liyang.interfaces.DBExecutor;

import java.sql.*;
import java.util.*;

/**
 * MySQL的执行类
 */
public class MySQLExecutor implements DBExecutor {

    /**
     * 连接处理类
     */
    private ConnectHandler connectHandler = new MySQLConnectHandler();

    /**
     * MySQL执行更新方法
     * @param sql 执行的SQL
     * @param param 参数                                         
     * @return
     */
    @Override
    public Integer executeUpdate(String sql, Object[] param) {

        //获取连接
        Connection connection = connectHandler.getConnection();

        //PreparedStatement
        PreparedStatement preparedStatement = null;

        //数据库受影响的行数
        Integer rows = 0;

        try {
            //预处理preparedStatement
            preparedStatement = connection.prepareStatement(sql);

            //如果参数数组存在，则设置参数
            if (param != null){
                for (int i = 0; i < param.length; i++) {
                    preparedStatement.setObject(i + 1, param[i]);
                }
            }

            //获得执行后的受影响行数
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭preparedStatement
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rows;
    }

    /**
     * MySQL执行查询方法
     * @param sql 执行的SQL
     * @param param 参数
     * @return
     */
    @Override
    public List<Map<String, Object>> executeQuery(String sql, Object[] param){

        //获取Connection
        Connection connection = connectHandler.getConnection();

        //PreparedStatement
        PreparedStatement preparedStatement = null;

        //结果集
        ResultSet resultSet = null;

        //接收结果集的集合对象
        List<Map<String, Object>> data = new ArrayList<>();

        try {
            //预处理preparedStatement
            preparedStatement = connection.prepareStatement(sql);

            //如果参数数组存在，则设置参数
            if (param != null){
                for (int i = 0; i < param.length; i++) {
                    preparedStatement.setObject(i + 1, param[i]);
                }
            }

            //获取结果集
            resultSet = preparedStatement.executeQuery();

            //将结果集封装
            data = resultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭结果集和preparedStatement
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    /**
     * 将ResultSet转换成List<Map>
     * @param rs 结果集
     * @return
     * @throws SQLException
     */
    private static List<Map<String,Object>> resultSetToList(ResultSet rs) throws SQLException{
        //装转换后结果的集合
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();

        //获得结果集的ResultSetMetaData对象
        ResultSetMetaData resultSetMetaData = rs.getMetaData();

        //获得列数
        int colCount = resultSetMetaData.getColumnCount();

        //列名List
        List<String> colNameList = new ArrayList<String>();

        //获得列名
        for(int i = 0; i < colCount; i++){
            colNameList.add(resultSetMetaData.getColumnName(i+1));
        }

        //遍历结果集，封装数据
        while(rs.next()){
            //装一行的数据
            Map map = new LinkedHashMap<String, Object>();

            //获取数据键值
            for(int i = 0; i < colCount; i++){
                //获取列名(字段名)
                String key = colNameList.get(i);

                //获取值
                Object value = rs.getString(colNameList.get(i));

                //封装
                map.put(key, value);
            }

            results.add(map);
        }

        return results;
    }

}
