package testData;

import org.json.JSONObject;

public class Test_Data {
    public int statusCode = 200;
    public String contentType ="application/json; charset=utf-8";
    //application/json
    //application/json; charset=utf-8
    public String header = "keep-alive";


    public  JSONObject getJsonPlaceHolderData(){
        JSONObject expData = new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
      return expData;
    }
    public JSONObject getExpDataJsonPlaceHolder(){
        JSONObject reqBody = new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);
        return reqBody;
    }
    public JSONObject getRequestBodyJsonPLaceHolder(){
        JSONObject resBody = new JSONObject();
        resBody.put("title","Ahmet");
        resBody.put("body","Merhaba");
        resBody.put("userId",10);
        resBody.put("id",70);
        return resBody;
    }
    public JSONObject getRequestDummy(){

        JSONObject innerData =new JSONObject();
        innerData.put("id",3);
        innerData.put("employee_name","Ashton Cox");
        innerData.put("employee_salary",86000);
        innerData.put("employee_age",66);
        innerData.put("profile_image","");



        return innerData;
    }
    public JSONObject expBodyJsonQ_20(){
        JSONObject expData= new JSONObject();
        expData.put("status","success");
        expData.put("data",getRequestDummy());
        expData.put("message","Successfully! Record has been fetched.");

        return expData;
    }

}
