import Service.*;
import Model.*;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;

public class Main {
   public static void main(String [] args) throws SQLException {

       CategortService categortService=new CategortService();
       ProductService productService = new ProductService();



       Category category=new Category(2,"test");

       Product product=new Product(1,"test",10,1);

        //-->addCategory
       //       int result;
//       result=categortService.add(category);
//       if(result == 0)
//           System.out.println("thisCategoryIdIsExists");
//       if(result==-1)
//           System.out.println("CategorryNotAdded");
//       if(result==1)
//           System.out.println("CategoryAdded");

       //-->addProduct
//      System.out.println(productService.add(product));

       //-->deleteProduct
       System.out.println(productService.delete(product));
   }

}
