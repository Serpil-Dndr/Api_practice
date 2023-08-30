package test;

import baseUrl.HerOkuBaseUrl;
import baseUrl.JsonPlaceHolderURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C09_practice extends JsonPlaceHolderURL {


//    @Test
//    public void get01(){
//
//        specHerokuApp.pathParams("pp1","booking","pp2",10);
//
//        Response response = given()
//                .spec(specHerokuApp).when().get("/{pp1}/{pp2}");
//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .contentType("application/json; charset=utf-8")
//                .header("Server","Cowboy")
//                .statusLine("HTTP/1.1 200 OK");
//
//
//    }
    @Test
    public void put01(){
//         specJsonPlace.pathParam("pp1","posts");
        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject regBody = new JSONObject();
        regBody.put("title","Ahmet");
        regBody.put("body","Merhaba");
        regBody.put("userId",10);
        regBody.put("id",70);
        //Formati json olan bir request body gonderdik
        //gonderdigimiz requesti bu reponse objecte kaydet.
        //gonderdigimiz req json formatinda ama sdk dan dolayi java olarak gondericez req.
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(regBody.toString())
                .put(url);
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");



    }
    @Test
    public void get02(){
        //specJsonPlace.pathParams("pp1","posts","pp2","44");
        String url = "https://jsonplaceholder.typicode.com/posts/44";
        Response response = given()

                .when()
                .get(url);
       response.then()
               .assertThat()
               .statusCode(200)
               .contentType("application/json; charset=utf-8")
               .body("userId",Matchers.equalTo(5)
                       ,"title",Matchers.equalTo("optio dolor molestias sit"));

    }

}
