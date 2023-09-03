package test;

import baseUrl.JsonPlaceHolderURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C21_Put_DeSerialization extends JsonPlaceHolderURL {

    @Test
    public void test01(){
        //1.url hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        //2.req body cagiriyoruz test datadan
        JsonPlaceHolderTestData testData = new JsonPlaceHolderTestData();
        HashMap<String, Object> reqBody = testData.getReqBodyJsonPlaceHolder();
        //3. expected data olustur
        HashMap<String, Object> expdata = testData.getReqBodyJsonPlaceHolder();
        //4.response kaydet
        Response response = given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/{pp1}/{pp2}");
        //response.prettyPeek();
        //Assertion
        HashMap<String,Object> resHashMAp= response.as(HashMap.class);
        Assert.assertEquals(expdata.get("title"),resHashMAp.get("title"));
        Assert.assertEquals(expdata.get("body"),resHashMAp.get("body"));
        Assert.assertEquals(expdata.get("userId"),resHashMAp.get("userId"));
        Assert.assertEquals(expdata.get("id"),resHashMAp.get("id"));



    }




}
