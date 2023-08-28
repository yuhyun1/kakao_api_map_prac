package validation;

public class InputValidation {

    public boolean isValidKeyword(String keyword) {
        return !keyword.isEmpty();
    }

    public boolean isValidRadius(String radiusStr) {
        try {
            int radius = Integer.parseInt(radiusStr);
            return radius > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidUrl(String url) {
        return url.matches("^https?://.*$");
    }

}