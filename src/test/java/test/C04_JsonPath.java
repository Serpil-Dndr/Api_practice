package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C04_JsonPath {
      /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */
    @Test
    public void jsonObject(){
        JSONObject mobilePhone= new JSONObject();
        mobilePhone.put("type","iPhone");
        mobilePhone.put("number","0123-4567-8888");

        JSONObject homePhone= new JSONObject();
        homePhone.put("type","home");
        homePhone.put("number","0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0,mobilePhone);
        phoneNumbers.put(1,homePhone);

        JSONObject address = new JSONObject();
        address.put("address","naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");

        JSONObject personInfo = new JSONObject();
        personInfo.put("firstname","John");
        personInfo.put("lastname","doe");
        personInfo.put("age",26);
        personInfo.put("address",address);
        personInfo.put("phoneNumbers",phoneNumbers);





        System.out.println(personInfo);
        System.out.println(personInfo.get("firstname"));
        System.out.println(personInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
    }

}
