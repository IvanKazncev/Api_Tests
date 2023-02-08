package Api;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();

    }
    public static void installSpec(ResponseSpecification response){
        RestAssured.responseSpecification =response;
    }
}
