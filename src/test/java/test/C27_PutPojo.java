package test;

import baseUrl.JsonPlaceHolderURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.Pojo_JsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C27_PutPojo extends JsonPlaceHolderURL {
    @Test
    public void test01(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        //2.req body hazirla
        Pojo_JsonPlaceHolder reqBody = new Pojo_JsonPlaceHolder("Ahmet","Merhaba",10,70);
        //3.expdata hazirla
        Pojo_JsonPlaceHolder expData = new Pojo_JsonPlaceHolder("Ahmet","Merhaba",10,70);
        //4.response kaydet
        Response response = given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/{pp1}/{pp2}");
        //Assertion
        Pojo_JsonPlaceHolder resPojo = response.as(Pojo_JsonPlaceHolder.class);
        Assert.assertEquals(expData.getTitle(),resPojo.getTitle());
        Assert.assertEquals(expData.getBody(),resPojo.getBody());
        Assert.assertEquals(expData.getUserId(),resPojo.getUserId());
        Assert.assertEquals(expData.getId(),resPojo.getId());



    }

}
