package Service;
import Model.Product;
import Repository.ProductRepository;
import Service.CategortService;
import org.DynamicArray.DynamicArrays;

import java.sql.SQLException;
import Utility.Validation;
public class ProductService {
    private Validation validation=new Validation();
    private CategortService categortService=new CategortService();
    private ProductRepository dataBase=new ProductRepository();

public int add(Product product) throws SQLException {

    if(!categortService.isCategoryIdExists(product.getCategoryId()))
        return 0;
        return dataBase.add(product);


}
public int delete(Product product) throws SQLException {
    return dataBase.delete(product.getId());

}
    public DynamicArrays searchForProductByName(Product product) throws SQLException {
        String name=validation.validNameForSelectQuery(product.getProductName());
        if(dataBase.searchForProductByName(name)==null)
            return null;
        else return dataBase.searchForProductByName(name);

}
}
