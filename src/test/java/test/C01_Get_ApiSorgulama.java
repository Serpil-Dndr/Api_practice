package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
     /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
    */



@Test
    public void get01(){
    //1. end point ve request body
    String url= "https://restful-booker.herokuapp.com/booking/10";
    //send request and save our response
    Response response = given().when().get(url);
   // response.prettyPrint();
    System.out.println(response.getStatusCode());
    System.out.println(response.getContentType());
    System.out.println(response.getHeader("Server"));
    //4. assertion
    response.then().assertThat()
            .statusCode(200)
            .header("Server","Cowboy")
            .contentType("application/json; charset=utf-8")
            .statusLine("HTTP/1.1 200 OK");


}

}
