package testData;

import org.json.JSONObject;
import org.junit.Test;

public class Test_Data {


    public  JSONObject getJsonPlaceHolderData(){
        JSONObject expData = new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
      return expData;
    }

}
