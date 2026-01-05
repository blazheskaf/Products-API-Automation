import client.ProductsClient;
import datafactory.ProductsDataFactory;
import io.restassured.response.Response;

import models.request.ProductsRequestModelPOSTPUT;
import models.response.ProductsResponseModelGET;
import org.junit.Test;

import java.util.List;

import static builder.ProductsObjectBuilder.creatingBody;
import static builder.ProductsObjectBuilder.updatingBody;
import static org.junit.Assert.*;

public class ProductsAPITests {

    @Test
    public void getAllProductsTest() {
        Response getResponse = new ProductsClient()
                .getAllProducts();

        assertEquals(200, getResponse.statusCode());

        List<ProductsResponseModelGET> getResponseList = getResponse
                .body()
                .jsonPath()
                .getList("products", ProductsResponseModelGET.class);
        assertFalse(getResponseList.isEmpty());
    }

    @Test
    public void getSingleProductTest() {
        Response getSingleResponse = new ProductsClient()
                .getSingleProduct("1");
        ProductsResponseModelGET responseProduct = getSingleResponse.body().as(ProductsResponseModelGET.class);
        assertEquals(200, getSingleResponse.statusCode());
        String description = "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.";
        assertEquals("Essence Mascara Lash Princess", responseProduct.getTitle());
        assertEquals(description, responseProduct.getDescription());

        assertEquals(9.99, responseProduct.getPrice(), 0.001);
        assertEquals(10.48, responseProduct.getDiscountPercentage(), 0.001);
        assertEquals(2.56, responseProduct.getRating(), 0.001);
        assertEquals(99, responseProduct.getStock());
        //проверка за листата tags
        assertEquals(2, responseProduct.getTags().size());
        assertTrue(responseProduct.getTags().contains("beauty"));
        assertTrue(responseProduct.getTags().contains("mascara"));
        assertEquals("Essence", responseProduct.getBrand());
        assertEquals("BEA-ESS-ESS-001", responseProduct.getSku());
        assertEquals(4, responseProduct.getWeight());
//DIMENSIONS:
        assertEquals(15.14, responseProduct.getDimensions().getWidth(), 0.001);
        assertEquals(13.08, responseProduct.getDimensions().getHeight(), 0.001);
        assertEquals(22.99, responseProduct.getDimensions().getDepth(), 0.001);

        assertEquals("1 week warranty", responseProduct.getWarrantyInformation());
        assertEquals("Ships in 3-5 business days", responseProduct.getShippingInformation());
        assertEquals("In Stock", responseProduct.getAvailabilityStatus());

        //REVIEWS
        assertEquals(3, responseProduct.getReviews().size());

        assertEquals(2.56, responseProduct.getRating(), 0.001);
        assertEquals("Would not recommend!", responseProduct.getReviews().get(0).getComment());
        assertEquals("2025-04-30T09:41:02.053Z", responseProduct.getReviews().get(0).getDate());
        assertEquals("Eleanor Collins", responseProduct.getReviews().get(0).getReviewerName());
        assertEquals("eleanor.collins@x.dummyjson.com", responseProduct.getReviews().get(0).getReviewerEmail());

        assertEquals(1, responseProduct.getImages().size());
        String image = " https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/1.webp";
        String thumbnail = "https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/thumbnail.webp";
        assertEquals(thumbnail, responseProduct.getThumbnail());
    }

    @Test

    public void postProductTest() {
        ProductsRequestModelPOSTPUT product1 = new ProductsDataFactory(creatingBody())
                .createRequest();
        Response response1 = new ProductsClient()
                .createProduct(product1);
        assertEquals(201, response1.statusCode());

        ProductsRequestModelPOSTPUT product2 = new ProductsDataFactory(creatingBody())

                .setName("Red Lipstick")
                .setPrice(20)
                .setDiscountPercentage(9.99)
                .setStock(10)
                .setRating(9.99)
                .setImages("https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg")
                .setThumbnail("https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg}")
                .setDescription("crven karmin")
                .setBrand("Frosina")
                .setCategory("makeup")
                .createRequest();
        Response response2 = new ProductsClient()
                .createProduct(product2);
        String image = "https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg";
        String thumbnail = "https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg}";
        assertEquals(201, response2.statusCode());
        assertEquals("Red Lipstick", product2.getName());
        assertEquals(20, product2.getPrice(), 0.001);
        assertEquals(9.99, product2.getDiscountPercentage(), 0.001);
        assertEquals(10, product2.getStock());
        assertEquals(9.99, product2.getRating(), 0.001);
        assertEquals(image, product2.getImages());
        assertEquals(thumbnail, product2.getThumbnail());
        assertEquals("crven karmin", product2.getDescription());
        assertEquals("Frosina", product2.getBrand());
        assertEquals("makeup", product2.getCategory());
    }

    @Test
    public void updateProductTest() {
        ProductsRequestModelPOSTPUT updatedProduct = new ProductsDataFactory(updatingBody())
                .createRequest();
        Response resposePut = new ProductsClient()
                .updateProduct(updatedProduct, "1");
        assertEquals(200, resposePut.statusCode());

        ProductsRequestModelPOSTPUT updatedPost2 = new ProductsDataFactory(updatedProduct)
                .setName("Alka")
                .setPrice(9.99)
                .setDiscountPercentage(9.99)
                .setStock(10)
                .setRating(9.99)
                .setImages("https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg")
                .setThumbnail("https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg}")
                .setDescription("Zlato")
                .setBrand("Ina")
                .setCategory("nakit")
                .createRequest();
        Response responseUpdate = new ProductsClient()
                .updateProduct(updatedPost2, "1");
        String image = "https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg";
        String thumbnail = "https://www.womensalphabet.com/wp-content/uploads/2020/12/red-lipstick-guide.jpg}";
        assertEquals(200, responseUpdate.statusCode(), 0.001);
        assertEquals("Alka", updatedPost2.getName());
        assertEquals(9.99, updatedPost2.getPrice(), 0.001);
        assertEquals(9.99, updatedPost2.getDiscountPercentage(), 0.001);
        assertEquals(10, updatedPost2.getStock());
        assertEquals(9.99, updatedPost2.getRating(), 0.001);
        assertEquals(image, updatedPost2.getImages());
        assertEquals(thumbnail, updatedPost2.getThumbnail());
        assertEquals("Zlato", updatedPost2.getDescription());
        assertEquals("Ina", updatedPost2.getBrand());
        assertEquals("nakit", updatedPost2.getCategory());
    }
    @Test
    public void deleteProductTest(){
        Response deleteResponse = new ProductsClient()
                .deleteProduct("1");
        assertEquals(200, deleteResponse.statusCode());


    }

}




