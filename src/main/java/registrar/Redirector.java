package registrar;

public class Redirector {
    private String successURL;
    private String errorURL;
    Redirector() {
        // TODO: init internals from environment
        successURL = "it works";
        errorURL = "it does not work";
    }
    private String set302(String url) {
        // TODO: do stuff to return the 302 with the url
        return url;
    } 
    public String success() {
        return set302(this.successURL);
    }
    public String error() {
        return set302(this.errorURL);
    }
}

// TODO: how to unittest this