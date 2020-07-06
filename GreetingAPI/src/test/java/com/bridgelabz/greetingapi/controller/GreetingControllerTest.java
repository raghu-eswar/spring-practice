package com.bridgelabz.greetingapi.controller;

import com.bridgelabz.greetingapi.model.Greeting;
import com.bridgelabz.greetingapi.model.Message;
import com.bridgelabz.greetingapi.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class GreetingControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void givenGreeting_addGreeting_shouldAddUserAndMessage() {
        User user = new User();
        Message message = new Message();
        user.setFirstName("Raghu");
        user.setLastName("Eswar");
        message.setMessage("hello");
        try {
            MvcResult result = mockMvc.perform(post("/GreetingAPI/Add")
                    .content(objectMapper.writeValueAsString(new Greeting(message, user)))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk()).andReturn();
            Greeting greeting = objectMapper.readValue(result.getResponse().getContentAsString(), Greeting.class);
            assertEquals(greeting.getUser().getId(), 1);
            assertEquals(greeting.getUser().getFirstName(), "Raghu");
            assertEquals(greeting.getUser().getMessageId(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGreeting_addGreeting_shouldOnlyAddUser() {
        User user = new User();
        Message message = new Message();
        user.setFirstName("Raghu");
        user.setLastName("Eswar");
        message.setMessage("hello");
        try {
            MvcResult result = mockMvc.perform(post("/GreetingAPI/Add")
                    .content(objectMapper.writeValueAsString(new Greeting(message, user)))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk()).andReturn();
            Greeting greeting = objectMapper.readValue(result.getResponse().getContentAsString(), Greeting.class);
            assertEquals(greeting.getUser().getId(), 1);
            assertEquals(greeting.getUser().getFirstName(), "Raghu");
            assertEquals(greeting.getUser().getMessageId(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGreetingId_getGreeting_shouldReturnGreeting() {
        try {
            MvcResult result = mockMvc.perform(get("/GreetingAPI/Get/1"))
                    .andExpect(status().isOk()).andReturn();
            Greeting greeting = objectMapper.readValue(result.getResponse().getContentAsString(), Greeting.class);
            assertEquals(greeting.getUser().getId(), 1);
            assertEquals(greeting.getUser().getFirstName(), "Raghu");
            assertEquals(greeting.getUser().getMessageId(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGreetingId_getGreeting_shouldReturnError() {
        try {
            mockMvc.perform(get("/GreetingAPI/Get/2"))
                    .andExpect(status().isNotFound()).andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGreetingIdAndUpdate_updateGreeting_shouldUpdateUser() {
        User user = new User();
        Message message = new Message();
        user.setFirstName("raghu");
        user.setLastName("eswar");
        message.setMessage("hi");
        try {
            MvcResult result = mockMvc.perform(put("/GreetingAPI/update/1")
                    .content(objectMapper.writeValueAsString(new Greeting(message, user)))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk()).andReturn();
            Greeting greeting = objectMapper.readValue(result.getResponse().getContentAsString(), Greeting.class);
            assertEquals(greeting.getUser().getId(), 1);
            assertEquals(greeting.getUser().getFirstName(), "raghu");
            assertEquals(greeting.getMessage().getMessage(), "hi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGreetingId_deleteGreeting_shouldDeleteUser() {
        try {
            MvcResult result = mockMvc.perform(delete("/GreetingAPI/delete/1"))
                    .andExpect(status().isOk()).andReturn();
            Greeting greeting = objectMapper.readValue(result.getResponse().getContentAsString(), Greeting.class);
            assertEquals(greeting.getUser().getId(), 1);
            assertEquals(greeting.getUser().getFirstName(), "raghu");
            assertEquals(greeting.getMessage().getMessage(), "hi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}