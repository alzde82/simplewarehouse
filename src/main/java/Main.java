import Service.*;
import Model.*;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;

public class Main {
   public static void main(String [] args) throws SQLException {
       CategortService categortService=new CategortService();
       Category category=new Category(2,"test");
       int result;
       result=categortService.add(category);
       if(result == 0)
           System.out.println("thisCategoryIdIsExists");
       if(result==-1)
           System.out.println("CategorryNotAdded");
       if(result==1)
           System.out.println("CategoryAdded");
       System.out.println("test");
   }

}
