package com.legend.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/25下午1:38
 */
@Controller
public class GreetingController {

  @GetMapping("/greeting")
  private String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                String name, Model model){
    model.addAttribute("name",name);
    return "greeting";
  }

}
