package test;

import baseUrl.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C05_Post_JsonBodyTest extends HerOkuBaseUrl {


    @Test
    public void get01(){
       /* 1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 24389 id'sine sahip bir booking oldugunu test edin
        //url and body*/
        specHerokuApp.pathParams("pp1","booking");
        //response kaydet
        Response response = given()
                .spec(specHerokuApp)
                .when()
                .get("/{pp1}");
        response.prettyPrint();
        //asertion
        response.then().assertThat().statusCode(200).body("bookingId",hasItem(3153));



    }
    @Test
    public void post01(){
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
        //end point and body
        specHerokuApp.pathParams("pp1","booking");
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
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(regBody.toString())
                .post("/{pp1}");
        response.prettyPrint();
        //Assertion
       // response.then().assertThat().statusCode(200).body("booking.firstname",equalTo("Henna"));


    }

}
