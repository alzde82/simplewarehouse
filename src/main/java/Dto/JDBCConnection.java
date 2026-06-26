package Dto;

import java.sql.*;


public class JDBCConnection {
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
            return connection;
    }
    public void closeConnections(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
        preparedStatement.close();
        resultSet.close();
        connection.close();
    }
    public void closeConnections(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        connection.close();
        preparedStatement.close();
    }
}
