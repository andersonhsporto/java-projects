package dev.anderson.themeparkapijenkins.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ThemeParkRideControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("GET /api/v1/ride - Success")
  public void getsAllRides() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ride")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
  }

  @Test
  @DisplayName("Gets a ride by id")
  public void getsRideById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ride/1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
  }

  @Test
  @DisplayName("Create a new ride")
  public void createRide() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/ride")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                "{\"name\":\"Test Ride\",\"description\":\"Test Ride Description\",\"thrillFactor\":5,\"vomitFactor\":1}")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
  }

}