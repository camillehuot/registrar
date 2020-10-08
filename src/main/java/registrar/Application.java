package registrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import registrar.Redirector;

@SpringBootApplication
@RestController
public class Application {
  private Redirector redirector = new Redirector();

  @RequestMapping("/register")
  public String register() {
    try {
      // parse the input
      // validate the input
      // register the email
      // return success
      return redirector.Success();
    }
    catch (Exception e) {
      // when error, return fail
      return redirector.Error();
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
