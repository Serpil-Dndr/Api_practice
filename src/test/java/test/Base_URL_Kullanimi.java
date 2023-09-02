package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Base_URL_Kullanimi {

    @Test
    public void test01(){
        //1.url hazirla
        String url = "https://jsonplaceholder.typicode.com/posts";
        //4.Response
        Response response =given()
                .when()
                .get(url);
        response.prettyPrint();
        //5. assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));

    }
    @Test
    public void test02(){
        String url = "https://jsonplaceholder.typicode.com/posts/50";
        Response response = given()
                .when()
                .delete(url);
       response.prettyPrint();
       //assertion
//        response.then().assertThat().statusCode(200)
//                .body("title", Matchers.nullValue());

    }
}
