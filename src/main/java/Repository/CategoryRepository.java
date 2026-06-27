package Repository;
import Model.Category;
import Dto.JDBCConnection;
import java.sql.*;
public class CategoryRepository {
    JDBCConnection jdbcConnection=new JDBCConnection();
    public int add(Category category) throws SQLException {
        JDBCConnection jdbcConnection=new JDBCConnection();
        Connection connection=jdbcConnection.getConnection();
        String insert="INSERT INTO category(categoryName) values(?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,category.getCategoryName());
        int result=preparedStatement.executeUpdate();
        jdbcConnection.closeConnections(connection,preparedStatement);
        return result;
    }
    public boolean isCategoryIdExists(int id) throws SQLException {
        Connection connection=jdbcConnection.getConnection();
        String select= "SELECT id FROM category WHERE id = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(select, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.previous();
        boolean result=resultSet.next();
        jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        return result;

    }
    public boolean isCategoryNameExists(String name) throws SQLException {
        Connection connection=jdbcConnection.getConnection();
        String select ="SELECT categoryName FROM category WHERE categoryname = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(select ,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.previous();
        boolean result=resultSet.next();
        jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        return result;
    }
}
