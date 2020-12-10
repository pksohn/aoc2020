import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        // Part 1
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            int number = Integer.parseInt(currentLine);
            int complement = 2020 - number;
            if (set.contains(complement)) {
                System.out.println("Part 1 Solution: " + number * complement);
                // Don't return early to initialize entire ArrayList for part 2.
            } else {
                set.add(number);
            }
            numbers.add(number);
        }

        // Part 2
        // Brute force.
        int i;
        for (i = 0; i < numbers.size(); i++) {
            HashSet<Integer> tempSet = new HashSet<>();
            int first = numbers.get(i);
            int j;
            for (j = i + 1; j < numbers.size(); j++) {
                int second = numbers.get(j);
                int complement = 2020 - first - second;
                if (tempSet.contains(complement)) {
                    System.out.println("Part 2 Solution: " + first * second * complement);
                    break;
                } else {
                    tempSet.add(second);
                }
            }
        }
    }
}
