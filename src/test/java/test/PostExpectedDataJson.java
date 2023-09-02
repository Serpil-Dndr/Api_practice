package test;

import baseUrl.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class PostExpectedDataJson extends HerOkuBaseUrl {

    @Test
    public void post01(){
        //1. url hazirla
        String url ="https://restful-booker.herokuapp.com";
      //  specHerokuApp.pathParam("pp1","booking");
        //2. request body hazirla
        JSONObject bookingdates= new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");
        JSONObject reqBody= new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalsneeds","wi-fi");
        //3.Response (expData)hazirla (donen response ile hazirladigimiz response assert ediyoruz.) o yuzden reponse body hazirlamamazi gerek
        JSONObject resBody= new JSONObject();
       // resBody.put("bookingid",24);
        resBody.put("booking",reqBody);
        //4.Hazirladigim req bodyi urle gonderdik ve doneni reponsa kaydediyoruz
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(url);
        response.prettyPrint();
        JsonPath resJsonPath = response.jsonPath();
        Assert.assertEquals(resBody.getJSONObject("booking").get("firstname"),resJsonPath.get("booking.firstname"));

    }
    @Test
    public void test01(){
       //1. Url hazirla
     String url ="https://dummy.restapiexample.com/api/v1/employee/3";
       //3. ExpData olustur
        JSONObject innerData =new JSONObject();
        innerData.put("id",3);
        innerData.put("employee_name","Ashton Cox");
        innerData.put("employee_salary",86000);
        innerData.put("employee_age",66);
        innerData.put("profile_image","");

        JSONObject expData= new JSONObject();
        expData.put("status","success");
        expData.put("data",innerData);
        expData.put("message","Successfully! Record has been fetched.");
        //4.responsu kaydet
        Response response= given()
                .when()
                .get(url);
        //5.assertion
        SoftAssert softAssert = new SoftAssert();
        JsonPath resJson = response.jsonPath();
        softAssert.assertEquals(resJson.get("status"),expData.get("status"));
        softAssert.assertEquals(resJson.get("data.id"),expData.getJSONObject("data").get("id"));
        softAssert.assertAll();







    }
}
