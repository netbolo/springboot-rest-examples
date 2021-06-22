package com.legend.resthateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/22下午5:55
 */
public class Greeting extends RepresentationModel<Greeting> {

  private final String content;

  @JsonCreator
  public Greeting(@JsonProperty("content") String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }
}
