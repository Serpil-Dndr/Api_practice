package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssert {

    @Test
    public void test01(){
        //1.url
        String url ="https://dummy.restapiexample.com/api/v1/employee/21";
        //2.req body
        JSONObject innerData = new JSONObject();
        innerData.put("name","Ahmet");
        innerData.put("salary","1230");
        innerData.put("age","44");
        innerData.put("id",40);
        JSONObject reqBody= new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",innerData);
        //3 expData hazirlinacak
        JSONObject expData = new JSONObject();
        expData.put("status","success");
        expData.put("data",reqBody);
        expData.put("message","Successfully! Record has been updated.");

        //4.responsu kaydet
        Response response= given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put(url);
        //5.donen reponsun assertion yap
        JsonPath resJsonPath = response.jsonPath();
        SoftAssert softAssert= new SoftAssert();
       // softAssert.assertEquals(resJsonPath.get("data.status"),expData.getJSONObject("data").get("status"));
        softAssert.assertEquals(resJsonPath.get("data.data.name")
                ,expData.getJSONObject("data").getJSONObject("data").get("name "));
        softAssert.assertAll();
    }
}
