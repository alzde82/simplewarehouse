package Model;
import lombok.*;
@Getter
@Setter
@ToString
public class Product {
   private int id;
    private String productName;
    private int quantity;
    private int categoryId;

    public Product(String productName,int quantity,int categoryId){
        this.productName=productName;
        this.quantity=quantity;
        this.categoryId=categoryId;
    }

}
