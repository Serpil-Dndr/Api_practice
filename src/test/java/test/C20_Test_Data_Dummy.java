package test;

import baseUrl.dummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.Test_Data;

import static io.restassured.RestAssured.given;

public class C20_Test_Data_Dummy extends dummyBaseUrl {
    @Test
    public void test01(){
        //1.url hazirla
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4","3");
         //3.exp data
        Test_Data testData = new Test_Data();
        JSONObject expData= testData.expBodyJsonQ_20();
        //4.responsu kaydet
        Response response = given()
                .spec(specDummy)
                .when()
                .get("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPrint();
        //assertion
        JsonPath resJson = response.jsonPath();
        Assert.assertEquals(expData.get("status"),resJson.get("status"));
        Assert.assertEquals(expData.get("message"),resJson.get("message"));

        Assert.assertEquals(expData.getJSONObject("data").get("id"),resJson.get("data.id"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_name"),resJson.get("data.employee_name"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_salary"),resJson.get("data.employee_salary"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_age"),resJson.get("data.employee_age"));
        Assert.assertEquals(expData.getJSONObject("data").get("profile_image"),resJson.get("data.profile_image"));



    }


}
