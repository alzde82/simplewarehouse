package Model;
import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
   private int id;
    private String productName;
    private int quantity;
    private int categoryId;
}
