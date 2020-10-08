package registrar;

public class Redirector {
    private String successURL;
    private String errorURL;
    Redirector() {
        // TODO: init internals from environment
        successURL = "it works";
        errorURL = "it does not work";
    }
    private String Set302(String url) {
        // TODO: do stuff to return the 302 with the url
        return url;
    } 
    public String Success() {
        return Set302(this.successURL);
    }
    public String Error() {
        return Set302(this.errorURL);
    }
}

// TODO: how to unittest this