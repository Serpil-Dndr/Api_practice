package test;

import baseUrl.HerOkuBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class QueryPAram extends HerOkuBaseUrl {

    @Test
    public void test01(){
        //1.set url
       specHerokuApp.pathParam("pp1","booking")
               .queryParam("firstname","Eric");

       //4.response object
        Response response = given()
                .spec(specHerokuApp)
                .when()
                .get("/{pp1}");
        response.prettyPrint();
        //5.assertion
        response.then().assertThat().statusCode(200)
                .body("bookingId", Matchers.notNullValue());//we check at least one value
    }
}
