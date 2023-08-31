package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

public class JsonPathKullanimi {

    @Test
    public void jsonPath01(){

        String url ="https://restful-booker.herokuapp.com/booking";


        JSONObject bookingDates= new JSONObject();
        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates",bookingDates);
        reqBody.put("additionalsneeds","wi-fi");
        //kendi olusturdugumuz req bodyi sout ile print edebiliriz
        System.out.println(reqBody);
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(url);
// Donen responsu yorumlayabilmek icin jsonpathe cevirmemiz gerekiyor.
        //expected data olmadigi icin jsonpath objesi olusturmaya gerek yok. reposnse kendi icnde test edildi. Jsonpath te noktalarla gidilir.
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname",equalTo("Ahmet"),
                       "booking.lastname", equalTo("Bulut"),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"));








    }
}
