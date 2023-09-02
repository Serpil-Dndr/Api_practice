package test;


import baseUrl.dummyBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class testListKullanimi  extends dummyBaseUrl{

   // static RequestSpecification specDummy;
    @Test
    public void get01() {
      //  specDummy = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com").build();

        // String url = "https://dummy.restapiexample.com";
       specDummy.pathParams("pp1", "api", "pp2", "v1", "pp3", "employees");
        Response response = given()
                .spec(specDummy)
                .when()
                .get("/{pp1}/{pp2}/{pp3}");

       // response.prettyPrint();

        //gelen listede 24 kisi olup olmadigini,Ashton Cox diye birinin olup olmadigini,
        //calisanlarda 61,30,40 yaslarinda birileri olup olmadigini test edin.
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data.id", hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,30,40));

    }
   @Test
    public void expectedData(){

    String url ="https://jsonplaceholder.typicode.com/post/22";
       JSONObject expData = new JSONObject();
       expData.put("userId",3);
       expData.put("id",22);
       expData.put("title","dolor sint quo a velit explicabo quia nam");
       expData.put("body","eos qui et ipsum ipsam suscipit aut" +
               "\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit" +
               "\nnam impedit esse");
       //System.out.println(expData);


       Response response = given().when().get(url);
       response.prettyPrint();
        //assertion
        JsonPath resJsonPath= response.jsonPath();
        Assert.assertEquals(expData.get("userId"),resJsonPath.get("userId"));



}
}
