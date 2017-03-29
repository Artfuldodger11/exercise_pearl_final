package project.service;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlValidatorImpl implements UrlValidator {

    public UrlValidatorImpl() {
    }

    public boolean validateUrl (String url) {

        URL urlValidTo = null;

        try {
            urlValidTo = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }

        try {
            urlValidTo.toURI();
        } catch (URISyntaxException e) {
            return false;
        }

        return true;
    }
}
