package registrar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.validator.routines.EmailValidator;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class RegistrationController {
  Redirector redirector = new Redirector();
  EmailValidator validator = EmailValidator.getInstance();
  Logger logger = LoggerFactory.getLogger(this.getClass());
  PersonRepository repository;

  public RegistrationController(PersonRepository repo) {
    this.repository = repo;
  }

  @PostMapping("/register")
  public void register(
      HttpServletResponse response,
      @RequestParam("email") String email) {

    logger.info("New request with email: " + email);

    // validate the input: WHY IS ANY STRING VALID!?!
    if (!validator.isValid(email)) {
        redirector.error(response);
    }

    // register the email
    repository.save(new Person(email, ""));

    // return success
    redirector.success(response);
  }

}
