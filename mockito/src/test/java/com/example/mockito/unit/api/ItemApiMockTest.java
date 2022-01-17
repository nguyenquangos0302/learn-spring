package com.example.mockito.unit.api;

import com.example.mockito.unit.model.Item;
import com.example.mockito.unit.service.IItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemApi.class)
public class ItemApiMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IItemBusinessService itemBusinessService;


    @Test
    public void helloWorld_basic() throws Exception {
        // call GET "hello-world" application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":10}"))
                .andReturn();

    }

    @Test
    public void getItemFromBusiness() throws Exception {
        // call GET "hello-world" application/json

        when(itemBusinessService.retrevueHardCodedItem()).thenReturn(
                new Item(2, "Item 2", 10, 10)
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(content().json("{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10}"))
                .andReturn();

    }

    @Test
    public void retrieveAllItems() throws Exception {
        // call GET "hello-world" application/json

        when(itemBusinessService.retrievAllItem()).thenReturn(
                Arrays.asList(new Item(2, "Item 2", 10, 10), new Item(3, "Item 3", 10, 10))
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(content().json("[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10}, {\"id\":3,\"name\":\"Item 3\",\"price\":10,\"quantity\":10}]"))
                .andReturn();

    }

}
