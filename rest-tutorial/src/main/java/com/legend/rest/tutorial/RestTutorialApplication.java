package com.legend.rest.tutorial;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23上午6:11
 */
@SpringBootApplication
public class RestTutorialApplication {
  public static void main(String[] args) {
    SpringApplication.run(RestTutorialApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
