package Service;
import Model.Category;
import Repository.CategoryRepository;

import java.sql.SQLException;

public class CategortService {
    private CategoryRepository dataBase=new CategoryRepository();


    public int add(Category category) throws SQLException {
        if(dataBase.isCategoryIdExists(category.getId()) || dataBase.isCategoryNameExists(category.getCategoryName()))
            return 0;
        return dataBase.add(category);
    }
}
