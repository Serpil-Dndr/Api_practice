package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class dummyBaseUrl {

    protected RequestSpecification specDummy;

    @Before
    public void setUp(){

        specDummy = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com")
                .build();


    }
}
