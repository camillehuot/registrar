package registrar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.validator.routines.EmailValidator;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cloudant.client.api.Database;


@Controller
public class RegistrationController {
  Redirector redirector = new Redirector();
  EmailValidator validator = EmailValidator.getInstance();
  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
	private Database db;

  @PostMapping("/register")
  public void register(
      HttpServletResponse response,
      @RequestParam("email") String email) {

    logger.info("new request with email: " + email);

    // validate the input: WHY IS ANY STRING VALID!?!
    if (!validator.isValid(email)) {
        redirector.error(response);
    }

    // register the email
    db.post(new Person(email, ""));

    // return success
    redirector.success(response);
  }

}
