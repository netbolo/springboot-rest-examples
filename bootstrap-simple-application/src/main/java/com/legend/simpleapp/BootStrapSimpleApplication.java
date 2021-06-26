package com.legend.simpleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23上午11:07
 */
//@EnableJpaRepositories()
@SpringBootApplication
public class BootStrapSimpleApplication {
  public static void main(String[] args) {
    SpringApplication.run(BootStrapSimpleApplication.class, args);
  }
}
