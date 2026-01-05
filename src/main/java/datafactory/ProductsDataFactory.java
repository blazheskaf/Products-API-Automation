package datafactory;

import models.request.ProductsRequestModelPOSTPUT;

public class ProductsDataFactory {
    private ProductsRequestModelPOSTPUT request;

    public ProductsDataFactory(ProductsRequestModelPOSTPUT requestBody) {
        request = requestBody;
    }

    public ProductsDataFactory setName(String name) {
        request.setName(name);
        return this;
    }

    public ProductsDataFactory setImages(String images) {
        request.setImages(images);
        return this;
    }

    public ProductsDataFactory setThumbnail(String thumbnail) {
        request.setThumbnail(thumbnail);
        return this;
    }

    public ProductsDataFactory setDescription(String description) {
        request.setDescription(description);
        return this;
    }

    public ProductsDataFactory setBrand(String brand) {
        request.setBrand(brand);
        return this;
    }

    public ProductsDataFactory setCategory(String category) {
        request.setCategory(category);
        return this;
    }

    public ProductsDataFactory setPrice(double price) {
       request.setPrice(price);
        return this;
    }

    public ProductsDataFactory setStock(int stock) {
        request.setStock(stock);
        return this;
    }

    public ProductsDataFactory setDiscountPercentage(double discountPercentage) {
        request.setDiscountPercentage(discountPercentage);
        return this;
    }

    public ProductsDataFactory setRating(double rating) {
        request.setRating(rating);
        return this;
    }
    public ProductsRequestModelPOSTPUT createRequest(){
        return request;
    }
}
