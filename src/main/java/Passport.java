import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}{6}$");
    private static final Pattern PID_PATTERN = Pattern.compile("^\\p{Digit}{9}$");

    private static final String[] required = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    private static final String[] EYE_COLOR_VALUES = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
    private static final Set<String> EYE_COLOR_SET = new HashSet<>(Arrays.asList(EYE_COLOR_VALUES));

    private final HashMap<String, String> attributes = new HashMap<>();

    public void add(String key, String value) {
        attributes.put(key, value);
    }

    public void parse(ArrayList<String> pairs) {
        for (String pair : pairs) {
            String[] pairSplit = pair.split(":");
            this.add(pairSplit[0], pairSplit[1]);
        }
    }

    public boolean validate(String key, String value) {
        if (key.equals("byr")) {
            return validateByr(value);
        }
        if (key.equals("iyr")) {
            return validateIyr(value);
        }
        if (key.equals("eyr")) {
            return validateEyr(value);
        }
        if (key.equals("hgt")) {
            System.out.println(value);
            return validateHeight(value);
        }
        if (key.equals("hcl")) {
            return validateHairColor(value);
        }
        if (key.equals("ecl")) {
            return validateEyeColor(value);
        }
        if (key.equals("pid")) {
            return validatePid(value);
        }
        return false;
    }

    private boolean validateYear(String value, int geq, int leq) {
        int year = Integer.parseInt(value);
        return value.length() == 4 && year >= geq && year <= leq;
    }

    private boolean validateByr(String value) {
        return validateYear(value, 1910, 2002);
    }

    private boolean validateIyr(String value) {
        return validateYear(value, 2010, 2020);
    }

    private boolean validateEyr(String value) {
        return validateYear(value, 2020, 2030);
    }

    private boolean validateHeight(String value) {
        String suffix = value.substring(value.length() - 2);
        if (suffix.equals("cm") || suffix.equals("in")) {
            int number = Integer.parseInt(value.substring(0, value.length() - 2));
            if (suffix.equals("cm")) {
                return number >= 150 && number <= 193;
            } else {
                return number >= 59 && number <= 76;
            }
        }
        return false;
    }

    private boolean validateHairColor(String value) {
        if (value.charAt(0) != '#') {
            return false;
        }
        ;
        final Matcher matcher = HEXADECIMAL_PATTERN.matcher(value.substring(1));
        return matcher.matches();
    }

    private boolean validateEyeColor(String value) {
        return EYE_COLOR_SET.contains(value);
    }

    private boolean validatePid(String value) {
        final Matcher matcher = PID_PATTERN.matcher(value);
        return matcher.matches();
    }

    public boolean requiredFieldsPresent() {
        for (String key : required) {
            if (attributes.get(key) == null) {
                return false;
            }
        }
        return true;
    }

    public boolean allFieldsValid() {
        for (String key : required) {
            String attribute = attributes.get(key);
            if (attribute == null || !validate(key, attribute)) {
                return false;
            }
        }
        return true;

    }
}
