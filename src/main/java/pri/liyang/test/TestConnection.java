package pri.liyang.test;

import pri.liyang.service.MySQLService;

import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws SQLException {

        System.out.println(new MySQLService().getAllTableName());

    }

}
