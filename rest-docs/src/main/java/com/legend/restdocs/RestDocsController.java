package com.legend.restdocs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/22下午2:16
 */
@RestController
public class RestDocsController {

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public Map<String, Object> greeting() {
    return Collections.singletonMap("message", "Rest Docs Demo");
  }
}
