package testData;

import org.json.JSONObject;

public class HerOkuTestData {
    public int statusCode = 200;
    public String contentType ="application/json; charset=utf-8";
    //application/json
    //application/json; charset=utf-8
    public String header = "keep-alive";
    public int succesStatusCode = 200;
    public JSONObject createBookingDateJSON(){

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }


    public JSONObject createBookingJSON(){

        JSONObject booking = new JSONObject();

        booking.put("firstname" , "Ahmet");
        booking.put("lastname" , "Bulut");
        booking.put("totalprice" , 500);
        booking.put("depositpaid" ,false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates" , createBookingDateJSON());

        return booking;
    }
    public JSONObject expectedBodyOlusturJSON(){

        JSONObject expData = new JSONObject();

        expData.put("bookingid" , 24);
        expData.put("booking" , createBookingJSON());

        return expData;
    }

}
