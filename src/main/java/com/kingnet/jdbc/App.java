package com.kingnet.jdbc;


import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //String url = "jdbc:mysql://192.168.78.105:3306/wutiao_article?user=kcoin&password=1GkcrKos2AEIE&useUnicode=true&characterEncoding=UTF8";
            connection = DriverManager.getConnection(args[0]);
            statement = connection.createStatement();
            //String sql = "select * from articles LI";
            System.out.println("sql语句---"+args[1]);
            resultSet = statement.executeQuery(args[1]);
            resultSet.beforeFirst();
            int c = 0;
            while (resultSet.next()) {
                System.out.println("执行次数"+c++);
            }
            System.out.println("成功操作数据库");
        } catch(Throwable t) {
            // TODO 处理异常
            t.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
