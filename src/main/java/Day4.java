import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> currentPairs = new ArrayList<>();
        int countValid = 0;
        int countValid2 = 0;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                Passport passport = new Passport();
                passport.parse(currentPairs);
                if (passport.requiredFieldsPresent()) {
                    countValid++;
                }
                if (passport.allFieldsValid()) {
                    countValid2++;
                }
                currentPairs = new ArrayList<>();
                continue;
            }
            currentPairs.addAll(Arrays.asList(line.split(" ")));
        }

        Passport passport = new Passport();
        passport.parse(currentPairs);
        if (passport.requiredFieldsPresent()) {
            countValid++;
        }
        if (passport.allFieldsValid()) {
            countValid2++;
        }

        System.out.println("Part 1 Solution: " + countValid);
        System.out.println("Part 2 Solution: " + countValid2);
    }
}
