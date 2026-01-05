package models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductsRequestModelPOSTPUT {
    String name, images, thumbnail, description, brand, category;
    int stock;
    double price,  discountPercentage, rating;
}