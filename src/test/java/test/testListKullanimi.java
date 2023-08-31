package test;


import baseUrl.dummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class testListKullanimi extends dummyBaseUrl {

@Test
    public void get01(){
     String url ="https://dummy.restapiexample.com/api/v1/employees";
    //specDummy.pathParams("pp1","api","pp2","v1","pp3","employee");
    Response response = given()
            //.spec(specDummy)
            .when()
            .get(url);
//preetypeek kaynagini kontrol,ediyor
   // response.prettyPeek();

    response.then()
            .assertThat()
            .statusCode(200)
            .contentType("application/json")
            .body("data.id", Matchers.hasSize(24)
                    ,"data.employee_name",
                    Matchers.hasItem("Ashton Cox"),
                    "data.employee_age",Matchers.hasItems(61,21,35)
            );



    }
   @Test
    public void expectedData(){

    String url ="https://jsonplaceholder.typicode.com/post/21";
        JSONObject expData= new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut" +
                "\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit" +
                "\nnam impedit esse");
        //System.out.println(expData);
        Response response= given()
                .when()
                .get(url);
        response.prettyPrint();
        //assertion
        JsonPath resJsonPath= response.jsonPath();
        Assert.assertEquals(expData.get("userId"),resJsonPath.get("userId"));



}
}
