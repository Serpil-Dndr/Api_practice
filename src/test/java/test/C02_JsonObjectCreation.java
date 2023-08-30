package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class C02_JsonObjectCreation {


  /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
        "title":"Jacob",
        "body":"Hello!",
        "userId":1
    }
    */
    @Test
    public void jsonObj(){
        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody = new JSONObject();

        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);


        //responsu kaydet
        Response response= given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put(url);
        response.prettyPrint();
        //assert yap
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }
      /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                                 },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
//    @Test
//    public void jsObj2(){
//          JSONObject outerJs = new JSONObject();
//          JSONObject bookingDates = new JSONObject();
//        bookingDates.put("checkin","2018-01-01");
//        bookingDates.put("checkout","2019-01-01");
//        outerJs.put("firstname","Jim");
//        outerJs.put("lastname","Carry");
//        outerJs.put("additionalneeds","Breakfast");
//        outerJs.put("totalprice","111");
//        outerJs.put("depositpaid","true");
//        outerJs.put("bookingDates",bookingDates);
//        System.out.println(outerJs);
//
//
//
//        //end point https://jsonplaceholder.typicode.com/posts/70
//        String url = "https://jsonplaceholder.typicode.com/posts/70";
//        //response u kaydet
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(outerJs.toString()).put(url);
//        response.prettyPrint();
//        //assertion
//        /*
//         status code’unun 200,
//            ve content type’inin application/json; charset=utf-8,
//            ve Server isimli Header’in degerinin cloudflare,
//            ve status Line’in HTTP/1.1 200 OK
//         */
//        response.then().assertThat()
//                .contentType("application/json; charset=utf-8")
//                .statusCode(200)
//                .body("firstname", Matchers.equalTo("Jim"))
//                .header("Server","cloudflare").statusLine("HTTP/1.1 200 OK");
//
//    }
}
