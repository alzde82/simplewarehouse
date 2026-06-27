package Repository;
import java.sql.*;
import Dto.JDBCConnection;
import Model.Product;
public class ProductRepository {
private     JDBCConnection jdbcConnection=new JDBCConnection();

    public int add(Product product) throws SQLException {
        Connection connection = jdbcConnection.getConnection();
        String insert="INSERT INTO product (name,quantity,categoryId )values(?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(insert);
        preparedStatement.setString(1,product.getProductName());
        preparedStatement.setInt(2,product.getQuantity());
        preparedStatement.setInt(3,product.getCategoryId());
        int result=preparedStatement.executeUpdate();
        jdbcConnection.closeConnections(connection,preparedStatement);
        return result;
    }
    public boolean isProductNameExists(String name) throws SQLException {
        Connection connection=jdbcConnection.getConnection();
        String select = "SELECT *FROM product WHERE name =?";
        PreparedStatement preparedStatement=connection.prepareStatement(select , ResultSet.TYPE_SCROLL_INSENSITIVE ,
                ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.previous();
        boolean result=resultSet.next();
        jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        return result;

    }
}
