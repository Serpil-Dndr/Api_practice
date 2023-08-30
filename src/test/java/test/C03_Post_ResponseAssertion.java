package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C03_Post_ResponseAssertion {
  /*
  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde{
        "title":"Java",
            "body":"Java is very powerfull language",
            "userId"19,
    }

   */
    @Test
    public void post01(){
        String url ="https://jsonplaceholder.typicode.com/posts";
        JSONObject jsBody= new JSONObject();
        jsBody.put("title","Java");
        jsBody.put("body","Java is very powerfull language");
        jsBody.put("userId",19);
        System.out.println(jsBody);
        //response kaydet
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsBody.toString())
                .post(url);
       // response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("Java"))
                .body("userId", Matchers.lessThan(100))
                .body("body", Matchers.containsString("Java"));


    }



}
