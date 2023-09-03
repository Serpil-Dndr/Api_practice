package testData;

import java.util.HashMap;

public class JsonPlaceHolderTestData {


    public HashMap getReqBodyJsonPlaceHolder() {
        //Eger hashmap olustruken degerlerden biri int ise onu double olarak olustur.
        HashMap<String, Object> reqBody = new HashMap<>();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10.0);
        reqBody.put("id",70.0);

        return reqBody;
    }
}