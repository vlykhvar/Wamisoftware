package com.geometry.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geometry.api.model.request.CircleRequest;
import com.geometry.api.model.request.RectangleRequest;
import com.geometry.api.model.request.SquareRequest;
import com.geometry.api.model.request.TriangleRequest;
import com.geometry.config.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class ShapeControllerTest {

    private static final BigDecimal TWENTY = BigDecimal.valueOf(20);
    private static final BigDecimal TEN = BigDecimal.valueOf(20);
    private static final BigDecimal SEVEN = BigDecimal.valueOf(7);
    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);
    private static final String EXPECTED_RESULT = "{\"area\": %s,\"perimeter\": %s}";
    private static final String CIRCLE_EXPECTED_RESULT = "{\"area\": %s,\"circumference\": %s}";
    private static final String URL = "/shapes";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCircleExpectedOk() throws Exception {
        var requestBody = objectMapper.writeValueAsString(prepareCircleRequest());
        var expectedResult = String.format(CIRCLE_EXPECTED_RESULT, 1256.0, 125.6);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResult));
    }

    @Test
    public void testCircleExpectedException() throws Exception {
        var circleRequest = prepareCircleRequest();
        circleRequest.setRadius(MINUS_ONE);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testCircleExpectedExceptionWithNull() throws Exception {
        var circleRequest = prepareCircleRequest();
        circleRequest.setRadius(null);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testSquareExpectedOk() throws Exception {
        var requestBody = objectMapper.writeValueAsString(prepareSquareRequest());
        var expectedResult = String.format(EXPECTED_RESULT, 400, 80);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResult));
    }

    @Test
    public void testSquareExpectedException() throws Exception {
        var circleRequest = prepareSquareRequest();
        circleRequest.setSide(MINUS_ONE);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testSquareExpectedExceptionWithNull() throws Exception {
        var circleRequest = prepareSquareRequest();
        circleRequest.setSide(null);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testRectangleExpectedOk() throws Exception {
        var requestBody = objectMapper.writeValueAsString(prepareRectangleRequest());
        var expectedResult = String.format(EXPECTED_RESULT, 400, 80);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResult));
    }

    @Test
    public void testRectangleWidthExpectedException() throws Exception {
        var circleRequest = prepareRectangleRequest();
        circleRequest.setWidth(MINUS_ONE);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testRectangleLengthExpectedException() throws Exception {
        var circleRequest = prepareRectangleRequest();
        circleRequest.setLength(MINUS_ONE);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testRectangleExpectedExceptionWithLengthNull() throws Exception {
        var circleRequest = prepareRectangleRequest();
        circleRequest.setLength(null);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testRectangleExpectedExceptionWithWidthNull() throws Exception {
        var circleRequest = prepareRectangleRequest();
        circleRequest.setWidth(null);

        var requestBody = objectMapper.writeValueAsString(circleRequest);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testTriangleExpectedOk() throws Exception {
        var requestBody = objectMapper.writeValueAsString(prepareTriangleRequest());
        var expectedResult = String.format(EXPECTED_RESULT, 68.91979034, 47);

        mockMvc.perform(MockMvcRequestBuilders.put(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResult));
    }

    private CircleRequest prepareCircleRequest() {
        var request = new CircleRequest();
        request.setRadius(TWENTY);
        return request;
    }

    private SquareRequest prepareSquareRequest() {
        var request = new SquareRequest();
        request.setSide(TWENTY);
        return request;
    }

    private RectangleRequest prepareRectangleRequest() {
        var request = new RectangleRequest();
        request.setLength(TWENTY);
        request.setWidth(TEN);
        return request;
    }

    private TriangleRequest prepareTriangleRequest() {
        var request = new TriangleRequest();
        request.setSideA(TWENTY);
        request.setSideB(TEN);
        request.setSideC(SEVEN);
        return request;
    }
}