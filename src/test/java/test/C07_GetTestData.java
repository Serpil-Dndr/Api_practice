package test;


import baseUrl.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.HerOkuTestData;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C07_GetTestData extends HerOkuBaseUrl {
    /*
   https://jsonplaceholder.typicode.com/posts/22 url'ine
   bir GET request yolladigimizda donen response body’sinin
   asagida verilen ile ayni oldugunu test ediniz

  Response body :
   {
   "userId":3,
   "id":22,
   "title":"dolor sint quo a velit explicabo quia nam",
   "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
    */
    @Test
    public void post01(){

        // 1 - Url ve Request Body hazirla

        specHerokuApp.pathParam("pp1","booking");

       HerOkuTestData herOkuTestData = new HerOkuTestData();

        JSONObject reqBody = herOkuTestData.createBookingJSON();

        // 2 - Expected Data hazirla

        JSONObject expData = herOkuTestData.expectedBodyOlusturJSON();

        // 3 - Responsu kaydet

        Response response = given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        assertEquals(herOkuTestData.succesStatusCode, response.getStatusCode());

        assertEquals(expData.getJSONObject("booking").get("firstname"), respJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"), respJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"), respJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"), respJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"), respJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                respJP.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                respJP.get("booking.bookingdates.checkout"));

    }
}
