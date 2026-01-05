package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.ProductsRequestModelPOSTPUT;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static utils.Configuration.BASE_URL_PRODUCTS;


public class ProductsClient {
    private static final Log log = LogFactory.getLog(ProductsClient.class);

    public Response createProduct (ProductsRequestModelPOSTPUT requestBody){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(BASE_URL_PRODUCTS + "/"+ "add")
                .thenReturn();
    }
    public Response getAllProducts(){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL_PRODUCTS)
                .thenReturn();
    }
    public Response getSingleProduct(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL_PRODUCTS + "/" + id)
                .thenReturn();
    }
    public Response updateProduct (ProductsRequestModelPOSTPUT updateRequestBody, String id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(updateRequestBody)
                .put(BASE_URL_PRODUCTS + "/" + id)
                .thenReturn();
    }
    public Response deleteProduct (String id) {
        return RestAssured
                .given()
                .when().log().all()
                .delete(BASE_URL_PRODUCTS + "/" + id)
                .thenReturn();
    }

}
