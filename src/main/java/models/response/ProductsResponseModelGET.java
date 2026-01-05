package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductsResponseModelGET {
    String id;
    String title;
    String description;
    String category;
    double price;
    double discountPercentage;
    double rating;
    int stock;
    List <String> tags;
    String brand;
    String sku;
    int weight;
    Dimensions dimensions;
    String warrantyInformation;
    String  shippingInformation;
    String availabilityStatus;
   List <Reviews> reviews;
    String returnPolicy;
    int minimumOrderQuantity;
    Meta meta;
    List <String> images;
    String thumbnail;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Dimensions {
        double width;
        double height;
        double depth;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Reviews{
        int rating;
        String comment;
        String date;
        String reviewerName;
        String reviewerEmail;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static  class Meta{
        String createdAt;
        String updatedAt;
        String barcode;
        String qrCode;
    }

}
