import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> currentPairs = new ArrayList<>();
        int countValid = 0;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                Passport passport = new Passport();
                passport.parse(currentPairs);
                if (passport.valid()) {
                    countValid++;
                }
                currentPairs = new ArrayList<>();
                continue;
            }
            currentPairs.addAll(Arrays.asList(line.split(" ")));
        }

        Passport passport = new Passport();
        passport.parse(currentPairs);
        if (passport.valid()) {
            countValid++;
        }

        System.out.println("Part 1 Solution: " + countValid);
    }
}
