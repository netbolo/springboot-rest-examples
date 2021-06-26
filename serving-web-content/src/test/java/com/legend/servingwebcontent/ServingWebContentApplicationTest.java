package com.legend.servingwebcontent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/25下午2:09
 */
@WebMvcTest(controllers = GreetingController.class)
class ServingWebContentApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void homePage() throws Exception {
    mockMvc.perform(get("/index.html"))
        .andExpect(content().string(containsString("Get your greeting")));
  }

  @Test
  public void greeting() throws Exception {
    mockMvc.perform(get("/greeting"))
        .andExpect(content().string(containsString("Hello, World!")));
  }

  @Test
  public void greetingWithUser() throws Exception {
    mockMvc.perform(get("/greeting").param("name", "Greg"))
        .andExpect(content().string(containsString("Hello, Greg!")));
  }
}
