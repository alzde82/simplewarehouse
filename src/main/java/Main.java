import Service.*;
import Model.*;
import Utility.Validation;
import org.DynamicArray.DynamicArrays;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;

public class Main {
   public static void main(String [] args) throws SQLException {
        Validation  validation= new Validation();
       CategortService categortService=new CategortService();
       ProductService productService = new ProductService();



       Category category=new Category(2,"test");

       Product product=new Product("m",10,1);

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
//       System.out.println(productService.add(product));

       //-->ListOfProductsByName
//        if(productService.searchForProductByName(product)==null)
//            System.out.println(-1);
//        else{
//            DynamicArrays list=productService.searchForProductByName(product);
//            for (int i = 0; i < list.length() ; i++) {
//                System.out.println(list.findObjectByIndex(i));
//            }
//       System.out.println(productService.increaseQuantityOfProduct(10,7));

       System.out.println(productService.decreaseQuantityOfProduct(11,));
   }


   }


