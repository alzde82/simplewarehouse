package Service;
import Model.Product;
import Repository.ProductRepository;
import Service.CategortService;
import java.sql.SQLException;
public class ProductService {

    private CategortService categortService=new CategortService();
    private ProductRepository dataBase=new ProductRepository();

public int add(Product product) throws SQLException {
    if(dataBase.isProductNameExists(product.getProductName()))
        return 0;
    if(!categortService.isCategoryIdExists(product.getCategoryId()))
        return 2;
        return dataBase.add(product);


}
public int delete(Product product) throws SQLException {
    return dataBase.delete(product.getId());

}

}
