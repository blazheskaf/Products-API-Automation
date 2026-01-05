package builder;

import models.request.ProductsRequestModelPOSTPUT;

public class ProductsObjectBuilder {

    public static ProductsRequestModelPOSTPUT creatingBody() {
        return ProductsRequestModelPOSTPUT.builder()
                .name("Default value")
                .price(0)
                .discountPercentage(0)
                .stock(0)
                .rating(0)
                .images("Default value")
                .thumbnail("Default value")
                .description("Default value")
                .brand("Default value")
                .category("Default value")
                .build();
    }
        public static ProductsRequestModelPOSTPUT updatingBody(){
            return ProductsRequestModelPOSTPUT.builder()
                    .name("Default value")
                    .price(0)
                    .discountPercentage(0)
                    .stock(0)
                    .rating(0)
                    .images("Default value")
                    .thumbnail("Default value")
                    .description("Default value")
                    .brand("Default value")
                    .category("Default value")
                    .build();

    }
}
