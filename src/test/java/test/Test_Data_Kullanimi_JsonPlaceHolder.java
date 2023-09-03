package test;

import baseUrl.JsonPlaceHolderURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.Test_Data;

import static io.restassured.RestAssured.given;

public class Test_Data_Kullanimi_JsonPlaceHolder extends JsonPlaceHolderURL {

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
        //1.url hzirladik
        specJsonPlace.pathParams("pp1","posts","pp2","70");
        //3.exp data
       Test_Data testData = new Test_Data();
       JSONObject expData = testData.getExpDataJsonPlaceHolder();
       //3. req body
        JSONObject reqBody = testData.getRequestBodyJsonPLaceHolder();
        // 4.reponse olustur
      Response response = given()
              .spec(specJsonPlace)
              .contentType(ContentType.JSON)
              .body(reqBody.toString())
              .when()
              .put("/{pp1}/{pp2}");
      response.prettyPrint();
      //5.Assertion
        JsonPath resJS = response.jsonPath();
      Assert.assertEquals(testData.statusCode,response.getStatusCode());
      Assert.assertEquals(testData.contentType,response.getContentType());
    //  Assert.assertEquals(testData.header,response.getHeaders()); //????????????
      Assert.assertEquals(expData.get("title"),resJS.get("title"));
      Assert.assertEquals(expData.get("body"),resJS.get("body"));
      Assert.assertEquals(expData.get("userId"),resJS.get("userId"));
      Assert.assertEquals(expData.get("id"),resJS.get("id"));



    }



}
