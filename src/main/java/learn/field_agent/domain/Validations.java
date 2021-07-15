package learn.field_agent.domain;

public class Validations {

    public static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
    public static boolean isDuplicateString(String newValue, String existingValue) {return newValue.equals(existingValue);}
}
