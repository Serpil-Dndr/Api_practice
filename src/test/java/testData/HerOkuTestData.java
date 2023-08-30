package testData;

import org.json.JSONObject;

public class HerOkuTestData {
    public int succesStatusCode = 200;
    public JSONObject createBookingDateJSON(){

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }


    public JSONObject createBookingJSON(){

        JSONObject booking = new JSONObject();

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
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
