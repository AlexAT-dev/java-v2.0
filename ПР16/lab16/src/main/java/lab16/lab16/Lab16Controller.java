package lab16.lab16;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lab16Controller {

  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }
}
