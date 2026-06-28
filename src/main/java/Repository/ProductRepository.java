package Repository;
import java.sql.*;
import Dto.JDBCConnection;
import Model.Product;
import org.DynamicArray.DynamicArrays;

import javax.xml.transform.Result;

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
        String select = "SELECT *FROM product WHERE name = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(select , ResultSet.TYPE_SCROLL_INSENSITIVE ,
                ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.previous();
        boolean result=resultSet.next();
        jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        return result;

    }
    public Product findProductById(int id) throws SQLException {
        Product product;
        Connection connection = jdbcConnection.getConnection();
        String select = "SELECT * FROM product WHERE id= ?";
        PreparedStatement preparedStatement=connection.prepareStatement(select);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            product=new Product(resultSet.getString("name"),resultSet.getInt("quantity")
                    ,resultSet.getInt("categoryid"));
            product.setId(resultSet.getInt("id"));
            jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        }
        else return null;

        return product;
    }
    public int delete(int id) throws SQLException {
        Connection connection=jdbcConnection.getConnection();
        String delete="delete from product where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        int result=preparedStatement.executeUpdate();
        jdbcConnection.closeConnections(connection,preparedStatement);
        return result;
    }
    public DynamicArrays searchForProductByName(String name) throws SQLException {

        DynamicArrays list=new DynamicArrays("Product");
        Connection connection = jdbcConnection.getConnection();
        String select ="SELECT * FROM product WHERE name LIKE  ?";
        PreparedStatement preparedStatement=connection.prepareStatement(select , ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setString(1, name);
        ResultSet resultSet=preparedStatement.executeQuery();
            list= listOfProducts(resultSet);
            jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
            return list;

    }

                    private DynamicArrays listOfProducts(ResultSet resultSet) throws SQLException {
                        DynamicArrays list=new DynamicArrays("Product");
                        if(!resultSet.next())
                            return null;
                        do{
                            Product product=new Product(resultSet.getString("name"),resultSet.getInt("quantity")
                                    ,resultSet.getInt("categoryid"));
                            product.setId(resultSet.getInt("id"));
                            list.add(product);
                        }
                        while(resultSet.next());

                        return list;
    }
    public int updateProductQuantity(int quantity,int id) throws SQLException {
        Connection connection = jdbcConnection.getConnection();
        String update= "UPDATE product SET quantity= quantity+ (?) WHERE ID =?";
        PreparedStatement preparedStatement=connection.prepareStatement(update);
        preparedStatement.setInt(1,quantity);
        preparedStatement.setInt(2,id);
        int result=preparedStatement.executeUpdate();
        jdbcConnection.closeConnections(connection,preparedStatement);
        return result;

    }
    public int QuantityOfProductById(int id) throws SQLException {
        Connection connection = jdbcConnection.getConnection();
        String select= "SELECT quantity FROM product WHERE id =?";
        PreparedStatement preparedStatement=connection.prepareStatement(select);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        int result=resultSet.getInt("quantity");
        jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        return result;

    }
    public boolean isProductIdExists(int id) throws SQLException {
        Connection connection = jdbcConnection.getConnection();
        String select ="select * from product where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(select);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        boolean result=resultSet.next();
        jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        return result;


    }
    public boolean isProductHaveQuantity(int id) throws SQLException {
        Connection connection = jdbcConnection.getConnection();
        String select="SELECT quantity FRoM product WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(select);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        if(resultSet.getInt("quantity")<=0) {
            jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
            return false;
        }
        else
            jdbcConnection.closeConnections(connection,preparedStatement,resultSet);
        return true;

    }
}
