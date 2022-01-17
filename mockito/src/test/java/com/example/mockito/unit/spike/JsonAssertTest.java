package com.example.mockito.unit.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":10}";

    @Test
    public void jsonAssert() throws JSONException {

        String assertResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":10}";

        JSONAssert.assertEquals(assertResponse, actualResponse, true);
    }

}
