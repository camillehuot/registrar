package registrar;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Redirector {
    private String successURL;
    private String errorURL;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    Redirector() {
        successURL = System.getenv().getOrDefault("REGISTRAR_SUCCESS_URL", "http://www.example.com/");
        logger.info("Success URL set to: " + successURL);
        errorURL = System.getenv().getOrDefault("REGISTRAR_ERROR_URL", "https://google.com/");
        logger.info("Error URL set to: " + errorURL);
    }
    private void set302(HttpServletResponse response, String url) {
        response.setHeader("Location", url);
        response.setStatus(302);
    } 
    public void success(HttpServletResponse response) {
        set302(response, this.successURL);
    }
    public void error(HttpServletResponse response) {
        set302(response, this.errorURL);
    }
}
