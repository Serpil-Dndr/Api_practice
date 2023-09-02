package test;

import baseUrl.JsonPlaceHolderURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.Test_Data;

import static io.restassured.RestAssured.given;

public class Test_Data_Kullanimi extends JsonPlaceHolderURL {

    @Test
    public void test01(){
        //1.Url hazirla
        specJsonPlace.pathParams("pp1","post","pp2","22");
        //2.expected  data olustur
        Test_Data testData = new Test_Data();
        JSONObject expData= testData.getJsonPlaceHolderData();
        //4.response
        Response response = given()
                .spec(specJsonPlace)
                .when()
                .get("/{pp1}/{pp2}");
        response.prettyPrint();
        //Assertion
        JsonPath resJP = response.jsonPath();
        Assert.assertEquals(expData.get("userId"),resJP.get("userId"));


    }
    @Test
    public void test02(){

    }



}
