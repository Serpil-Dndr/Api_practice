package test;

import baseUrl.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.HerOkuTestData;

import static io.restassured.RestAssured.given;

public class C21_Post_TestData_Heroku extends HerOkuBaseUrl {
    @Test
    public void test01(){
        //Url hazirla
    specHerokuApp.pathParam("pp1","booking");
        //2.reg body olustur
        HerOkuTestData testData = new HerOkuTestData();

        JSONObject reqBody = testData.createBookingJSON();

        //3.exp data olustur
        JSONObject expData = testData.expectedBodyOlusturJSON();
        //4.reponsu kaydet
        Response response = given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post("/{pp1}");

        response.prettyPrint();
        //assertion
        JsonPath respJSon = response.jsonPath();
        Assert.assertEquals(testData.succesStatusCode, response.getStatusCode());
        Assert.assertEquals(testData.contentType,response.getContentType());
        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"), respJSon.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"), respJSon.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"), respJSon.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"), respJSon.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"), respJSon.get("booking.additionalneeds"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                respJSon.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                respJSon.get("booking.bookingdates.checkout"));




    }

}
