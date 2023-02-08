package Api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class FirstApiTests {
    private final static String URL = "https://reqres.in/";
    @Test
    public void checkAvatar(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+ "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

    }
    @Test

    public void regCheck(){
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in","pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .contentType(ContentType.JSON)
                .post(URL+"api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());

    }

    @Test

    public void createCheck(){
        Specifications.installSpec(Specifications.responseSpecification());
        CreatData api = new CreatData("morpheus","leader");
        SuccesCreate succesCreate = given()
                .body(api)
                .when()
                .contentType(ContentType.JSON)
                .post(URL+"api/users")
                .then().log().all()
                .extract().as(SuccesCreate.class);
        Assert.assertEquals(api.getName(), succesCreate.getName());

    }

}
