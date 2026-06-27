package Model;
import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    int id;
    String productName;
    int quantity;
    int categoryId;
}
