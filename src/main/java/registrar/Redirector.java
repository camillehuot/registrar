package registrar;

import javax.servlet.http.HttpServletResponse;

public class Redirector {
    private String successURL;
    private String errorURL;
    Redirector() {
        successURL = System.getenv("REGISTRAR_SUCCESS_URL");
        if (successURL == null) {
            successURL = "http://www.example.com/";
        }
        errorURL = System.getenv("REGISTRAR_ERROR_URL");
        if (errorURL == null) {
            errorURL = "https://google.com/";
        }
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
