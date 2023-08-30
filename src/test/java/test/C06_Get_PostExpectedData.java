package test;

import baseUrl.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C06_Get_PostExpectedData extends HerOkuBaseUrl {
 /*
        2- https://restful-booker.herokuapp.com/booking endpointine asagidaki
         body’ye sahip bir POST request gonderdigimizde donen response’un status
         code’unun 200 oldugunu ve “firstname” degerinin “Ali” oldugunu test edin

      {
      "firstname" : "Henna",
      "lastname" : “Ray",
      "totalprice" : 500,
      "depositpaid" : false,
      "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                    },
      "additionalneeds" : "wi-fi"
       }

      */
    @Test
    public void postExpected(){
        String url = " https://restful-booker.herokuapp.com/booking";
        //specHerokuApp.pathParams("pp1","booking");
        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");
        JSONObject regBody = new JSONObject();
        regBody.put("firstname","Henna");
        regBody.put("lastname","Ray");
        regBody.put("totalprice",500);
        regBody.put("depositpaid", false);
        regBody.put("bookingdates",innerBody);
        regBody.put("additionalneeds","wi-fi");
        //responsu kaydet
         Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(regBody.toString())
                .post(url);
        //response body for exp data
        JSONObject expData = new JSONObject();
        expData.put("bookingid",24);
        expData.put("booking",regBody);

        response.prettyPrint();
        //assertion
        //httpden gelen responsu json formatinda sorgulayabilmek icin jsonpath objesi olarak soruguladik
        JsonPath responseJson = response.jsonPath();
        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"),responseJson.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJson.get("booking.bookingdates.checkin"));
    }

}
