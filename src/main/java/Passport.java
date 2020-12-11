import java.util.ArrayList;
import java.util.HashMap;

public class Passport {

    HashMap<String, String> attributes = new HashMap<>();
    String[] required = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    public void add(String key, String value) {
        attributes.put(key, value);
    }

    public void parse(ArrayList<String> pairs) {
        for (String pair : pairs) {
            String[] pairSplit = pair.split(":");
            this.add(pairSplit[0], pairSplit[1]);
        }
    }

    public boolean requiredFieldsPresent() {
        for (String key : required) {
            if (attributes.get(key) == null) {
                return false;
            }
        }
        return true;
    }
}
